import express from 'express'
import HomePage from './components/HomePage.js'
import PassInput from './components/PassInput.js'
import FailInput from './components/FailInput.js'
import { validateDay, validateMonth, validateYear } from './model/validationFactory.js'
import getAge from './model/getAge.js'

const app = express()
app.listen(3000, () => console.log('Listening on port 3000'))

app.use(express.static('public'));
app.use(express.urlencoded({ extended: false }));

app.get('/', (req, res) => {
	res.send(HomePage())
})

app.post('/input', (req, res) => {
	const day = req.body.DD
	const month = req.body.MM
	const year = req.body.YYYY

	const dayCheck = validateDay(day, month, year)
	const monthCheck = validateMonth(month, year)
	const yearCheck = validateYear(year)

	const dayRes = dayCheck.pass ? `${PassInput("DAY", "DD", day)}` : `${FailInput("DAY", "DD", day, dayCheck.message)}`
	const monthRes = monthCheck.pass ? `${PassInput("MONTH", "MM", month)}` : `${FailInput("MONTH", "MM", month, monthCheck.message)}`
	const yearRes = yearCheck.pass ? `${PassInput("YEAR", "YYYY", year)}` : `${FailInput("YEAR", "YYYY", year, yearCheck.message)}`

	if (!dayCheck.pass || !monthCheck.pass || !yearCheck.pass) {
		res.setHeader('hx-reswap', 'none')
		return res.status(422).send(`
${dayRes} 
${monthRes}
${yearRes}
`)
	}
	const returnObj = getAge(day, month, year)

	res.send(`
<div><span>${returnObj.calculatedYear}</span> years</div>
<div><span>${returnObj.calculatedMonth}</span> months</div>
<div><span>${returnObj.calculatedDay}</span> days</div>

${dayRes}
${monthRes}
${yearRes}
`)
})
