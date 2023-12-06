#include <iostream>
#include <cstdlib>
#include <cmath>
using namespace std;

int main() {
	int x1, y1, r1;  // 조규환 위치
	int x2, y2, r2;  // 백승환 위치
	int T;  // 테스트 케이스 수
	double d;  // 조규환과 백승환 거리
	int result = 0;   // 결과

	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;  // 테스트 케이스 입력

		d = sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));  // 조규환과 백승환의 거리 계산

		if ((r1 + r2) < d)   // case 1 : 교점x, 만나지 않은 두 원
			result = 0;

		else if (abs(r1 - r2) > d)  // case 2 : 교점x, 원안에 원
			result = 0;

		else if (d == 0 && r1 == r2)  // case 5 : 무한대, 똑같은 원
			result = -1;

		else if ((r1 + r2) == d)  // case 3 : 교점 1, 외접
			result = 1;

		else if (abs(r1 - r2) == d)  // case 4 : 교점 1, 내접
			result = 1;

		else  //case 6 : 교점 2
			result = 2;

		cout << result << endl;
	}
}