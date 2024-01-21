import java.util.HashSet;
import java.util.Set;

public class FrogRiverCrossing {

    public static int earliestTimeToCross(int X, int[] A) {
        Set<Integer> positionsCovered = new HashSet<>();
        Set<Integer> targetPositions = new HashSet<>();

        for (int i = 1; i <= X; i++) {
            targetPositions.add(i);
        }

        for (int second = 0; second < A.length; second++) {
            positionsCovered.add(A[second]);

            if (positionsCovered.equals(targetPositions)) {
                return second;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int X = 6;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4, 6};

        int earliestTime = earliestTimeToCross(X, A);

        if (earliestTime != -1) {
            System.out.println("Самое раннее время для перепрыгивания: " + earliestTime);
        } else {
            System.out.println("Невозможно перепрыгнуть через реку в заданных условиях.");
        }
    }
}

