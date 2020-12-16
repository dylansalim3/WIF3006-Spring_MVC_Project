<%@ include file="common/header.jspf" %>

<div class="jumbotron">
    <h2 class="text-center">Health Assessment</h2>
    <p class="text-center">Fill in your detail and we will assess your body health!</p>

    <div class="container col-md-6 ">
        <form:form method="POST" action="/assessment/submit" cssClass="d-flex flex-column justify-content-center">

            <div class="form-group">
                <label for="age" class="col-form-label">Age: </label>
                <div class="input-group">
                    <input id="age" class="form-control" name="age" type="number" required/>
                    <div class="input-group-append">
                        <span class="input-group-text">Ages 15-80</span>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="height" class="col-form-label">Height: </label>
                <div class="input-group">
                    <input id="height" class="form-control" name="height" type="number" required/>
                    <div class="input-group-append">
                        <span class="input-group-text">cm</span>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="weight" class="col-form-label">Weight: </label>
                <div class="input-group">
                    <input id="weight" class="form-control" type="number" name="weight" required>
                    <div class="input-group-append">
                        <span class="input-group-text">kg</span>
                    </div>
                </div>
            </div>

            <fieldset class="form-group">
                <div class="row">
                    <legend class="col-form-label col-sm-2 pt-0">Gender:</legend>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="gender" id="gridRadios1"
                                   value="male" checked>
                            <label class="form-check-label" for="gridRadios1">
                                Male
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="gender" id="gridRadios2"
                                   value="female">
                            <label class="form-check-label" for="gridRadios2">
                                Female
                            </label>
                        </div>
                    </div>
                </div>
            </fieldset>

            <div class="form-group">
                <label for="exerciseLevel" class="col-form-label">Exercise Level</label>
                <select id="exerciseLevel" class="custom-select" name="exerciseLevelId" required>
                    <option selected value="">Select Exercise Level</option>

                    <c:forEach items="${exerciseLevels}" var="exerciseLevel">
                        <option value="${exerciseLevel.id}">${exerciseLevel.exerciseLevel}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="bmiFormula" class="col-form-label">BMR Estimation formula</label>
                <select id="bmiFormula" class="custom-select" name="calorieFormula" required>
                    <option selected value="">Select BMR Estimation formula</option>

                    <c:forEach items="${bmrFormulaList}" var="bmrFormula">
                        <option value="${bmrFormula}">${bmrFormula}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group" id="form-group-body-fat">
                <label for="bodyFat" class="col-form-label">Body Fat: </label>
                <div class="input-group">
                    <input id="bodyFat" class="form-control" type="number" name="bodyFat" value="0">
                    <div class="input-group-append">
                        <span class="input-group-text">%</span>
                    </div>
                </div>
            </div>

            <button id="btn-submit" type="submit" class="btn btn-primary">Calculate</button>


        </form:form>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

    <script>
        $(document).ready(function () {
            var exerciseLevel = $("#exerciseLevel");
            var bmiFormula = $("#bmiFormula");
            console.log(bmiFormula.val());
            $("#form-group-body-fat").hide();

            bmiFormula.on("change", function () {
                if (bmiFormula.val() == "Katch-McArdle Formula") {
                    $("#form-group-body-fat").show();
                }else {
                    $("#form-group-body-fat").hide();
                }
            });

            // $("#btn-submit").click(function () {
            //     if (exerciseLevel.val() == "") {
            //         alert("Exercise Level is empty");
            //     }
            // })
        });
    </script>

    <%@ include file="common/footer.jspf" %>
