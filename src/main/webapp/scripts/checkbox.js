
function toggleCheckboxes(checkbox) {
    var checkboxes = document.querySelectorAll('.employee-checkbox');
    for (var i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = checkbox.checked;
    }
}


document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('deleteButton').addEventListener('click', function(event) {
        var checkedBoxes = document.querySelectorAll('input[name="employee_ids"]:checked');
        if (checkedBoxes.length === 0) {
            alert('Please select at least one employee to delete.');
            event.preventDefault();
        } else if (!confirm('Are you sure you want to delete selected employees?')) {
            event.preventDefault();
        }
    });
});
