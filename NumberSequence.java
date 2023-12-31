import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Set;
import java.util.List;

public class NumberSequence {
	public static void main(String[] args) {

		final Integer numberOfRows = 12;
		
		BelowDiagonalTraversal myTraversal = new BelowDiagonalTraversal(numberOfRows);

		TreeMap<List<Integer>, Integer> myMap = new TreeMap<>(new Comparator<List<Integer>>() {
			public int compare(List<Integer> lst1, List<Integer> lst2) {
				for (int i = 0; i < lst1.size(); ++i) {
					if (lst1.get(i) > lst2.get(i))
						return -1;
					else if (lst1.get(i) < lst2.get(i))
						return 1;
				}
				return 0;
			}
		});

		List<Integer> arr = new ArrayList<Integer>(numberOfRows);

		while (myTraversal.getCurrentIndex() != 0) {
			arr = Arrays.stream(myTraversal.makeMonotonicBubbleSortLike()).toList();

			if (myMap.get(arr) != null) {
				myMap.put(arr, (Integer) myMap.get(arr) + 1);
			} else {
				myMap.put(arr, 1);
			}

			myTraversal.Next();
		}

		Set<List<Integer>> keySet = myMap.keySet();

		int i = 1;
		for (List<Integer> key : keySet) {
			System.out.print(i + " " + myMap.get(key));
			++i;
			System.out.println();
		}

		return;
	}
}
