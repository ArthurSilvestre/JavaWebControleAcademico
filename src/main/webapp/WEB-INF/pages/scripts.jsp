<!-- jQuery Library -->
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<!--materialize js-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
	    $('select').material_select();
	});
	
	$('select').material_select('destroy');
	
	function filter(index_filter, id_input_filter, table) {
	    var input, filter, table, tr, td, i;
	
	    input = document.getElementById(id_input_filter);
	    filter = input.value.toUpperCase();
	    table = document.getElementById(table);
	    tr = table.getElementsByTagName("tr");
	
	    for (i = 0; i < tr.length; i++) {
	
	        td = tr[i].getElementsByTagName("td")[index_filter];
	
	        if (td) {
	            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	                tr[i].style.display = "";
	            } else {
	                tr[i].style.display = "none";
	            }
	        }
	
	    }
	
	}

	function filter_two_fields(index_filter_first, index_filter_second, id_input_filter_first, id_input_filter_second, table) {
	    var input_first, input_second, filter_first, filter_second, table, tr, td, i;
	
	    input_first = document.getElementById(id_input_filter_first);
	    filter_first = input_first.value.toUpperCase();

	    input_second = document.getElementById(id_input_filter_second);
	    filter_second = input_second.value.toUpperCase();

	    table = document.getElementById(table);
	    tr = table.getElementsByTagName("tr");
	
	    for (i = 0; i < tr.length; i++) {
	
	        td = tr[i].getElementsByTagName("td")[index_filter_first];
	        td2 = tr[i].getElementsByTagName("td")[index_filter_second];

	    	if (filter_first){
		        if (td) {
		            if (td.innerHTML.toUpperCase().indexOf(filter_first) > -1) {
		                tr[i].style.display = "";
		            } else {
		                tr[i].style.display = "none";
		            }
		        }
	    	} else {
                tr[i].style.display = "";
	    	}
	
	    	if (filter_second){
		        if (td2) {
		            if (td2.innerHTML.toUpperCase().indexOf(filter_second) > -1) {
		                tr[i].style.display = "";
		            } else {
		                tr[i].style.display = "none";
		            }
		        }
	    	} else {
                tr[i].style.display = "";
	    	}

	    }
	
	}	
  
</script>