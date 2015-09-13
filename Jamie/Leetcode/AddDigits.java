//Add Digits 
public int addDigits(int num) {
	if (num < 10 && num >=0) {
		return num;
	} else {
		return (num - 1) % 9 + 1;
	}

