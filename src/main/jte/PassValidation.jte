<!-- NOTE: need fullyqualified name for jte import -->
@import com.mycompany.app.model.ValidateResultObject
@import com.mycompany.app.model.CalculatedBirthday

@param String inputDayValue
@param String inputMonthValue
@param String inputYearValue

@param ValidateResultObject dayResult
@param ValidateResultObject monthResult
@param ValidateResultObject yearResult
@param CalculatedBirthday birthday

<div><span>${birthday.getYear()}</span> years</div>
<div><span>${birthday.getMonth()}</span> months</div>
<div><span>${birthday.getDay()}</span> days</div>

<!-- clean up input components below -->
<!-- Day component -->
<div id='DAY-card' hx-swap-oob='true'>
  <label>
    <div class="${dayResult.isPassing() != true ? " warning" : null }">DAY</div>
    <input type="text" class="margin-top ${dayResult.isPassing() != true ? " bg_warning" : null }"
      value="${inputDayValue}" placeholder="DD" name="DD" />
  </label>
  <div class="${dayResult.isPassing() != true ? " margin-top warning" : null }" id='DAY-message'>
    ${dayResult.getMessage()}</div>
</div>

<!-- Month component -->
<div id='MONTH-card' hx-swap-oob='true'>
  <label>
    <div class="${monthResult.isPassing() != true ? " warning" : null }">MONTH</div>
    <input type="text" class="margin-top ${monthResult.isPassing() != true ? " bg_warning" : null }"
      value="${inputMonthValue}" placeholder="MM" name="MM" />
  </label>
  <div class="${monthResult.isPassing() != true ? " margin-top warning" : null }" id='MONTH-message'>
    ${monthResult.getMessage()}</div>
</div>

<!-- Year component -->
<div id='YEAR-card' hx-swap-oob='true'>
  <label>
    <div class="${yearResult.isPassing() != true ? " warning" : null }">YEAR</div>
    <input type="text" class="margin-top ${yearResult.isPassing() != true ? " bg_warning" : null }"
      value="${inputYearValue}" placeholder="YYYY" name="YYYY" />
  </label>
  <div class="${yearResult.isPassing() != true ? " margin-top warning" : null }" id='YEAR-message'>
    ${yearResult.getMessage()}</div>
</div>
