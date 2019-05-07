package com.magneto.platformer.entity.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.magneto.platformer.entity.components.TextureComponent;
import com.magneto.platformer.entity.components.TransformComponent;
import lombok.Getter;

import java.util.Comparator;

public class RenderingSystem extends SortedIteratingSystem {

    @Getter private OrthographicCamera camera; // a reference to our camera
    private SpriteBatch batch; // a reference to our spritebatch
    private Array<Entity> renderQueue; // an array used to allow sorting of images allowing us to draw images on top of each other
    private Comparator<Entity> comparator; // a comparator to sort images based on the z position of the transfromComponent
    private ComponentMapper<TransformComponent> transform;

    // component mappers to get components from entities
    private ComponentMapper<TextureComponent> texture;

    public RenderingSystem(SpriteBatch batch) {
        // gets all entities with a TransformComponent and TextureComponent
        super(Family.all(TextureComponent.class).get(),new ZComparator());

        //creates out componentMappers
        texture = ComponentMapper.getFor(TextureComponent.class);

        transform = ComponentMapper.getFor(TransformComponent.class);

        // create the array for sorting entities
        renderQueue = new Array<Entity>();

        this.batch = batch;  // set our batch to the one supplied in constructor

        // set up the camera to match our screen size
        camera = new OrthographicCamera(800, 480);
    }


    @Override
    public void update(float deltaTime) {

        super.update(deltaTime);

        // sort the renderQueue based on z index
        renderQueue.sort(comparator);

        // update camera and sprite batch
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.enableBlending();
        batch.begin();

        // loop through each entity in our render queue
        for (Entity entity : renderQueue) {
            TextureComponent tex = texture.get(entity);
            TransformComponent t = transform.get(entity);

            if (tex.region == null || t.isHidden) {
                continue;
            }

            batch.draw(tex.currentRegion,t.position.x,t.position.y, 50, 50); // Draw current frame at (50, 50)

        }

        batch.end();
        renderQueue.clear();
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        renderQueue.add(entity);
    }

}
