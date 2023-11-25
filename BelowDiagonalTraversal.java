package src;

public class BelowDiagonalTraversal {
	private int n = 12;
	private int currentIndex = n - 1;
	private int pt = n - 1;
	private int[] list = new int[n];

	public BelowDiagonalTraversal() {
		for (int i = 0; i < n; ++i) {
			list[i] = i + 1;
		}
	}

	public void Next() {
		if (list[pt] > 1) {
			list[pt] -= 1;
		}

		else if (currentIndex != 0 && list[pt] == 1) {
			--currentIndex;
			while (list[currentIndex] == 1 && currentIndex > 0) {
				--currentIndex;
			}

			if (currentIndex == 0)
				return;

			--list[currentIndex];
			for (int i = currentIndex + 1; i < n; ++i) {
				list[i] = i + 1;
			}
			pt = n - 1;
			currentIndex = pt;
		}

	}

	public void printList() {
		for (int i = 0; i < n; ++i)
			System.out.print(list[i] + " ");

		System.out.println();
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public int[] makeMonotonicBubbleSortLike() {
		var arr = list.clone();
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j] + 1;
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		return arr;
	}

}
