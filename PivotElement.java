package baazigames;

public class PivotElement {

    public static int balancedSum(int arr[]) {

        int n = arr.length, result = 0, leftSum = 0, rightSum = 0;

        for (int i = 0; i < n; i++) {
            rightSum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            rightSum -= arr[i];

            if (rightSum == leftSum)
                return i;

            leftSum += arr[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 6};

        int val = balancedSum(arr);

        System.out.println(val);

    }
}
