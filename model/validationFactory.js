const validationFactory = (time) => {
	return (day, month, year) => {
		const dayInt = +day
		const monthInt = +month
		const yearInt = +year
		const returnObj = {
			target: time,
			pass: true,
			message: ''
		}

		const genericMessage = 'Must be a valid '
		const pastMessage = 'Must be in the past'
		const requiredMessage = 'This field is required'

		if (time === 'day') {
			if (day === '') {
				returnObj.pass = false
				returnObj.message = requiredMessage
				return returnObj
			}
			const dateObj = new Date(yearInt, monthInt - 1, dayInt)
			if (dayInt !== 0 && !dayInt) {
				returnObj.message = genericMessage + 'day'
			}
			if (dateObj.getFullYear() === new Date().getFullYear() &&
				dateObj.getMonth() === new Date().getMonth() &&
				dateObj > new Date()) {
				returnObj.message = pastMessage
			}
			if (dateObj.getDate() && dateObj.getDate() !== dayInt) {
				returnObj.message = genericMessage + 'day'
			}
			if (returnObj.message.length > 1) returnObj.pass = false
		} else if (time === 'month') {
			if (month === '') {
				returnObj.pass = false
				returnObj.message = requiredMessage
				return returnObj
			}
			if (monthInt !== 0 && !monthInt) {
				returnObj.message = genericMessage + 'month'
			}
			if (yearInt === new Date().getFullYear() &&
				monthInt > new Date().getMonth() + 1) {
				returnObj.message = pastMessage
			}
			if (monthInt < 1 || monthInt > 12) {
				returnObj.message = genericMessage + 'month'
			}
			if (returnObj.message.length > 1) returnObj.pass = false
		} else if (time === 'year') {
			if (year === '') {
				returnObj.pass = false
				returnObj.message = requiredMessage
				return returnObj
			}
			if (yearInt > new Date().getFullYear()) {
				returnObj.message = pastMessage
			}
			if (yearInt.toString().length < 4 || year.length > 4) {
				returnObj.message = 'Please enter a year in YYYY format'
			}
			if (yearInt !== 0 && !yearInt || yearInt < 0) {
				returnObj.message = genericMessage + 'year'
			}
			if (returnObj.message.length > 1) returnObj.pass = false
		}
		return returnObj
	}
}

const validateDay = validationFactory('day')
const validateMonth = validationFactory('month').bind(null, null)
const validateYear = validationFactory('year').bind(null, null, null)

export { validateDay, validateMonth, validateYear }
