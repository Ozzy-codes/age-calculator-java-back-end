@param String name
@param String abv
@param String value

<div id='${name}-card' hx-swap-oob="true">
  <label>
    <div>${name}</div>
    <input type="text" class="margin-top" value="${value}" name="${abv}" />
  </label>
  <div id='${name}-message'></div>
</div>
