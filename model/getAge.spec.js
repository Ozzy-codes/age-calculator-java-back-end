import { it, expect } from "vitest"
import getAge from "./getAge"

it('should get correct age if birth month is === to the current month and the birth day of the month is the same day as today', () => {
	const day = new Date().getDate()
	const month = ((new Date().getMonth() + 1) % 13) || 1
	const year = new Date().getFullYear() - 1

	const output = getAge(day, month, year)

	expect(output.calculatedDay).toBe(0)
	expect(output.calculatedMonth).toBe(0)
	expect(output.calculatedYear).toBe(1)
})
it('should get correct age if birth month is === to the current month and the birth day of the month is < today', () => {
	//	TODO: write a better test to handle 1st of the month
	const day = new Date().getDate()
	if (day === 1) return
	const updatedDay = day - 1
	const month = ((new Date().getMonth() + 1) % 13) || 1
	const year = new Date().getFullYear() - 1


	const output = getAge(updatedDay, month, year)

	expect(output.calculatedDay).toBe(1)
	expect(output.calculatedMonth).toBe(0)
	expect(output.calculatedYear).toBe(1)
})
it('should get correct age if birth month is === to the current month and the birth day of the month is > today', () => {
	const day = new Date().getDate() + 1
	const month = ((new Date().getMonth() + 1) % 13) || 1
	const year = new Date().getFullYear() - 1
	const daysInTheMonth = new Date(year + 1, month, 0).getDate()
	const calculatedDay = daysInTheMonth - day + (day - 1)
	//	TODO: determine better handling for end of month
	if (day > daysInTheMonth) return

	const output = getAge(day, month, year)

	expect(output.calculatedDay).toBe(calculatedDay)
	expect(output.calculatedMonth).toBe(11)
	expect(output.calculatedYear).toBe(0)
})
it('should get correct age if birth month is > than current month and the birth day of the month is the === day as today', () => {
	const day = new Date().getDate()
	const month = new Date().getMonth() + 2
	const year = new Date().getFullYear() - 1
	if (month > 12) return

	const output = getAge(day, month, year)

	expect(output.calculatedDay).toBe(0)
	expect(output.calculatedMonth).toBe(11)
	expect(output.calculatedYear).toBe(0)
})
it('should get correct age if birth month is > than current month and the birth day of the month is > today', () => {
	const day = new Date().getDate() + 1
	const month = new Date().getMonth() + 2
	const year = new Date().getFullYear() - 1
	const currentDay = new Date().getDate()
	const currentMonth = new Date().getMonth()
	const calculatedDay = (new Date(year + 1, currentMonth, 0).getDate()) - day + currentDay
	if (month > 12) return

	const output = getAge(day, month, year)

	expect(output.calculatedDay).toBe(calculatedDay)
	expect(output.calculatedMonth).toBe(10)
	expect(output.calculatedYear).toBe(0)
})
it('should get correct age if birth month is > than current month and the birth day of the month is < today', () => {
	const day = new Date().getDate() - 1
	const month = new Date().getMonth() + 2
	const year = new Date().getFullYear() - 1
	const currentDay = new Date().getDate()
	const currentMonth = new Date().getMonth()
	const calculatedDay = (new Date(year + 1, currentMonth, 0).getDate()) - currentDay + day
	if (day < 1) return

	const output = getAge(day, month, year)

	expect(output.calculatedDay).toBe(calculatedDay)
	expect(output.calculatedMonth).toBe(11)
	expect(output.calculatedYear).toBe(0)
})
it('should get correct age if birth month is < than the current month and birth day of the month is the === as today', () => {
	const day = new Date().getDate()
	const month = new Date().getMonth() || 12
	const year = new Date().getFullYear() - 1

	const output = getAge(day, month, year)

	expect(output.calculatedDay).toBe(0)
	expect(output.calculatedMonth).toBe(1)
	expect(output.calculatedYear).toBe(1)
})
it('should get correct age if birth month is < than the current month and birth day of the month is > today', () => {
	const day = new Date().getDate() + 1
	const month = new Date().getMonth() || 12
	const year = new Date().getFullYear() - 1
	const calculatedDay = (new Date(year + 1, month, 0).getDate()) - day + (day - 1)

	const output = getAge(day, month, year)

	expect(output.calculatedDay).toBe(calculatedDay)
	expect(output.calculatedMonth).toBe(0)
	expect(output.calculatedYear).toBe(1)
})
it('should get correct age if birth month is < than the current month and birth day of the month is < today', () => {
	const day = new Date().getDate() - 1
	const month = new Date().getMonth() || 12
	const year = new Date().getFullYear() - 1
	if (day < 1) return

	const output = getAge(day, month, year)

	expect(output.calculatedDay).toBe(1)
	expect(output.calculatedMonth).toBe(1)
	expect(output.calculatedYear).toBe(1)
})
