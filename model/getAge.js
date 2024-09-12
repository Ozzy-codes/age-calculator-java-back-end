const getAge = (birthDay, birthMonth, birthYear) => {
	const birthDayInt = +birthDay
	const birthMonthIdx = +birthMonth - 1
	const birthYearInt = +birthYear

	const currentDate = new Date()
	const currYear = currentDate.getFullYear()
	const currMonth = currentDate.getMonth()
	const currDay = currentDate.getDate()

	const monthDiff = birthMonthIdx - currMonth
	const dayDiff = birthDayInt - currDay

	let calculatedYear;
	let calculatedMonth;
	let calculatedDay;

	if (monthDiff === 0) {
		if (dayDiff > 0) {
			calculatedYear = currYear - birthYearInt - 1
			calculatedMonth = 11
			calculatedDay = (new Date(currYear, currMonth + 1, 0).getDate()) - birthDayInt + currDay
		} else {
			calculatedYear = currYear - birthYearInt
			calculatedMonth = 0
			calculatedDay = currDay - birthDayInt
		}
		return { calculatedYear, calculatedMonth, calculatedDay }
	} else if (monthDiff > 0) {
		calculatedYear = currYear - birthYearInt - 1
		calculatedMonth = 11 - birthMonthIdx + currMonth
		if (dayDiff === 0) {
			calculatedMonth += 1
			calculatedDay = 0
		} else if (dayDiff > 0) {
			calculatedDay = (new Date(currYear, currMonth, 0).getDate()) - birthDayInt + currDay
		} else {
			calculatedDay = currDay - birthDayInt
			calculatedMonth += 1
		}
		return { calculatedYear, calculatedMonth, calculatedDay }
	} else if (monthDiff < 0) {
		calculatedYear = currYear - birthYearInt
		calculatedMonth = currMonth - birthMonthIdx
		if (dayDiff === 0) {
			calculatedDay = 0
		} else if (dayDiff < 0) {
			calculatedDay = currDay - birthDayInt
		} else {
			calculatedDay = (new Date(currYear, birthMonthIdx + 1, 0).getDate()) - birthDayInt + currDay
			calculatedMonth -= 1
		}
		return { calculatedYear, calculatedMonth, calculatedDay }
	}
}

export default getAge
