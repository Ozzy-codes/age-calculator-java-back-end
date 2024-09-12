const ReactiveCard = (name, abv) => {
	return `
<div id='${name}-card'>
  <label><div>${name}</div>
  <input 
type="text"
class="margin-top"
placeholder="${abv}"
name="${abv}"
/></label>
<div id='${name}-message'></div>
</div>
`
}
export default ReactiveCard
