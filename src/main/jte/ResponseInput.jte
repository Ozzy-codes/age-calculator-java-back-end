<!-- Day component -->
<div id='DAY-card' hx-swap-oob='true'>
  <label>
    <div class="${dayResult.getPassing() != true ? " warning" : "" }">DAY</div>
    <input type="text" class="margin-top ${dayResult.getPassing() != true ? " bg_warning" : "" }"
      value="${inputDayValue}" placeholder="DD" name="DD" />
  </label>
  <div class="${dayResult.getPassing() != true ? " margin-top warning" : "" }" id='DAY-message'>
    ${dayResult.getMessage()}</div>
</div>

<!-- Month component -->
<div id='MONTH-card' hx-swap-oob='true'>
  <label>
    <div class="${monthResult.getPassing() != true ? " warning" : "" }">MONTH</div>
    <input type="text" class="margin-top ${monthResult.getPassing() != true ? " bg_warning" : "" }"
      value="${inputMonthValue}" placeholder="MM" name="MM" />
  </label>
  <div class="${monthResult.getPassing() != true ? " margin-top warning" : "" }" id='MONTH-message'>
    ${monthResult.getMessage()}</div>
</div>

<!-- Year component -->
<div id='YEAR-card' hx-swap-oob='true'>
  <label>
    <div class="${yearResult.getPassing() != true ? " warning" : "" }">YEAR</div>
    <input type="text" class="margin-top ${yearResult.getPassing() != true ? " bg_warning" : "" }"
      value="${inputYearValue}" placeholder="YYYY" name="YYYY" />
  </label>
  <div class="${yearResult.getPassing() != true ? " margin-top warning" : "" }" id='YEAR-message'>
    ${yearResult.getMessage()}</div>
</div>
