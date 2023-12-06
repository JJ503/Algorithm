#include <iostream>
using namespace std;

int main() {
	int n, answer = 0;
	int hundreds, tens, units;

	cin >> n;

	for (int i = 1; i < n + 1; i++) {
		if (i < 100)
			answer++;

		else {
			hundreds = i / 100;
			tens = i % 100 / 10;
			units = i % 10;
			if ((hundreds - tens) == (tens - units))
				answer++;
		}
	}

	cout << answer;
}