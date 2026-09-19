/**
 * Maths: Minimum Distance from the Circle's Center to the Rectangle
 * Time: O(1)
 * Space: O(1)
 */
public class OverlappingRectanglesCircles {

    public boolean checkOverlap(
            int radius,
            int xCenter,
            int yCenter,
            int x1,
            int y1,
            int x2,
            int y2
    ) {
        // Tracks the squared minimum distance (xmin^2 + ymin^2) from the circle's center to the rectangle.
        double dist = 0;

        // Compute xmin^2: If the center is outside the x-bounds [x1, x2], 
        // add the squared distance to the closest vertical edge.
        // If inside [x1, x2], xmin is 0 and this block is skipped.
        if (xCenter < x1 || xCenter > x2) {
            dist += Math.min(
                    Math.pow(x1 - xCenter, 2), // Squared distance to the left edge (x1)
                    Math.pow(x2 - xCenter, 2) // Squared distance to the right edge (x2)
            );
        }

        // Compute ymin^2: If the center is outside the y-bounds [y1, y2], 
        // add the squared distance to the closest horizontal edge.
        // If inside [y1, y2], ymin is 0 and this block is skipped.
        if (yCenter < y1 || yCenter > y2) {
            dist += Math.min(
                    Math.pow(y1 - yCenter, 2), // Squared distance to the bottom edge (y1)
                    Math.pow(y2 - yCenter, 2) // Squared distance to the top edge (y2)
            );
        }

        // Check if the closest point on the rectangle is within the circle.
        // We compare squared distance (xmin^2 + ymin^2) to radius^2 to avoid floating-point square root operations.
        return dist <= radius * radius;
    }
}
