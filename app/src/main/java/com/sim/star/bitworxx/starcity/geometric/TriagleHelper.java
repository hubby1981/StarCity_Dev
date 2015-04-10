package com.sim.star.bitworxx.starcity.geometric;

import android.graphics.Path;
import android.graphics.Point;

import com.sim.star.bitworxx.starcity.game.enums.Direction;

/**
 * Created by WEIS on 10.04.2015.
 */
public class TriagleHelper {

    public static Path getTriangle(Point p1, int factor, int margin, Direction direction) {
        Point p2 = null, p3 = null;

        if (direction == Direction.WEST) {
            p2 = new Point(p1.x + margin / factor, p1.y);
            p3 = new Point(p1.x, p1.y + margin / factor);

        } else if (direction == Direction.EAST) {
            p2 = new Point(p1.x - margin / factor, p1.y);
            p3 = new Point(p1.x, p1.y + margin / factor);

        } else if (direction == Direction.SOUTH) {
            p2 = new Point(p1.x - margin / factor, p1.y);
            p3 = new Point(p1.x, p1.y - margin / factor);

        } else if (direction == Direction.NORTH) {
            p2 = new Point(p1.x + margin / factor, p1.y);
            p3 = new Point(p1.x, p1.y - margin / factor);

        }

        Path path = new Path();
        path.moveTo(p1.x, p1.y);
        path.lineTo(p2.x, p2.y);
        path.lineTo(p3.x, p3.y);

        return path;
    }
}
