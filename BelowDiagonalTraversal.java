import java.util.ArrayList;
import java.util.List;

public class BelowDiagonalTraversal {
	private Integer n;
	private Integer currentIndex;
	private Integer pt;
	private List<Integer> list = new ArrayList<Integer>();


	public BelowDiagonalTraversal(Integer n) {
		this.n = n;
	    this.currentIndex = n-1;
		this.pt = n-1;
		for (Integer i = 0; i < n; ++i) {
			list.add(i+1);
		}
	}

	public void Next() {
		if (list.get(pt) > 1) {
			list.set(pt, list.get(pt)-1);
		}

		else if (currentIndex != 0 && list.get(pt) == 1) {
			--currentIndex;
			while (list.get(currentIndex) == 1 && currentIndex > 0) {
				--currentIndex;
			}

			if (currentIndex == 0)
				return;

			list.set(currentIndex, list.get(currentIndex)-1);
			for (Integer i = currentIndex + 1; i < n; ++i) {
				list.set(i, i+1);
			}
			pt = n - 1;
			currentIndex = pt;
		}

	}

	public void printList() {
		for (Integer i = 0; i < n; ++i)
			System.out.print(list.get(i) + " ");

		System.out.println();
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public Integer[] makeMonotonicBubbleSortLike() {
		Integer[] arr = new Integer[list.size()];
		arr = list.toArray(arr);
		Integer n = arr.length;
		for (Integer i = 0; i < n - 1; ++i)
			for (Integer j = 0; j < n - i - 1; ++j)
				if (arr[j] > arr[j + 1]) {
					Integer temp = arr[j] + 1;
					arr[j] = arr[j+1];
					arr[j + 1] = temp;
				}
		return arr;
	}

}
