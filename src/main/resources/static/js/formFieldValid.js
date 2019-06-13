/**
 * 
 */
$(function() {
		$("#dateOfBirth").datepicker({
			changeMonth : true,
			changeYear : true
		})
	})
	function scheduleA(event) {
		var value = this.options[this.selectedIndex].text;
		var val = document.getElementById("TextBoxDiv1");
		if (!val) {
			if ((value === 'Widower' || value === 'Divorced')) {
				var newTextBoxDiv = $(document.createElement('div')).attr("id",
						'TextBoxDiv' + 1).attr("class", 'form-group');

				newTextBoxDiv
						.after()
						.html(
								'<label>No. of Children  :'
										+ '</label>'
										+ '<input type="text" name="othersComplexion' + 
	     '" id="textbox'+ '"  class="form-control input-sm" path="" >');

				newTextBoxDiv.appendTo("#noOfIssuesDiv");
			} else {
				document.getElementById("TextBoxDiv1").remove();

			}
		} else {
			if (value === 'Single') {

				document.getElementById("TextBoxDiv1").remove();
			}

		}
	}