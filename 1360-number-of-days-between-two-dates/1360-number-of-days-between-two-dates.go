func daysBetweenDates(date1 string, date2 string) int {
	slice1 := strings.Split(date1, "-")
	slice2 := strings.Split(date2, "-")

	year1, _ := strconv.Atoi(slice1[0])
	month1, _ := strconv.Atoi(slice1[1])
	day1, _ := strconv.Atoi(slice1[2])

	year2, _ := strconv.Atoi(slice2[0])
	month2, _ := strconv.Atoi(slice2[1])
	day2, _ := strconv.Atoi(slice2[2])

	if year1 > year2 || (year1 == year2 && month1 > month2) || (year1 == year2 && month1 == month2 && day1 > day2) {
		return daysBetweenDates(date2, date1)
	}

	ret := 0
	ret += daysInYears(year1, year2)
	ret -= daysInMonths(year1, 1, month1-1)
	ret -= daysInMonths(year2, month2, 12)
	ret -= day1
	ret += day2

	return ret
}

var monthDays = []int{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}

func daysInMonths(year, from, to int) int {
	days := 0
	for month := from; month <= to; month++ {
		days += monthDays[month-1]
		if isLeapYear(year) && month == 2 {
			days++
		}
	}
	return days
}

func daysInYears(from, to int) int {
	leaps := 0
	for year := from; year <= to; year++ {
		if isLeapYear(year) {
			leaps++
		}
	}
	return 365*(to-from+1) + leaps
}

func isLeapYear(year int) bool {
	return (year%400 == 0) || ((year%4 == 0) && (year%100 != 0))
}