<%@ include file="common/header.jspf" %>
<div class="jumbotron">
    <p class="text-center display-4">Result</p>
    <p class="lead text-center">Result of your body assessment</p>
    <hr>
    <div class="container bg-white">
        <div class="row">
            <div class="col-md-8 order-md-1">
                <h4>BMI</h4>
                <hr>
                <p>Your BMI level is: ${bmi}</p>
                <p>You are ${bmiCategory}</p>
            </div>
            <div class="col-md-4 order-md-2 mb-4">

            </div>
        </div>
        <div>

            <h4>Calorie</h4>
            <hr>
            <p>The results show a number of daily calorie estimates that can be used as a guideline for how many calories to consume each day to maintain, lose, or gain weight at a chosen rate.</p>
            <ul class="list-group">
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Maintain weight</h6>
                    </div>
                    <div>
                        <div class="d-flex justify-content-between align-items-center">
                            <h6 class="m-0">${caloriesToMaintain}</h6>
                            <small>100%</small>
                        </div>
                        <small>Calories/day</small>
                    </div>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Mild weight loss</h6>
                        <small class="text-muted">0.25kg/week</small>
                    </div>
                    <div>
                        <div class="d-flex justify-content-between align-items-center">
                            <h6 class="m-0">${caloriesToMildWeightLoss}</h6>
                            <small>100%</small>
                        </div>
                        <small>Calories/day</small>
                    </div>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Weight loss</h6>
                        <small class="text-muted">0.50kg/week</small>
                    </div>
                    <div>
                        <div class="d-flex justify-content-between align-items-center">
                            <h6 class="m-0">${caloriesToWeightLoss}</h6>
                            <small>100%</small>
                        </div>
                        <small>Calories/day</small>
                    </div>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Extreme Weight loss</h6>
                        <small class="text-muted">0.50kg/week</small>
                    </div>
                    <div>
                        <div class="d-flex justify-content-between align-items-center">
                            <h6 class="m-0">${caloriesToExtremeWeightLoss}</h6>
                            <small>100%</small>
                        </div>
                        <small>Calories/day</small>
                    </div>
                </li>
            </ul>
            <c:if test="${caloriesToExtremeWeightLoss<=1500}">
                <c:out value="Please consult with a doctor when losing 1 kg or more per week since it requires that you consume less than the minimum recommendation of 1,500 calories a day."/>
            </c:if>
        </div>

        <div id="ideal-weight">
            <h4>Ideal Weight</h4>
            <hr>
            <p>Your ideal weight is: ${idealWeight} kg</p>
        </div>



    </div>
    <%@ include file="common/footer.jspf" %>
