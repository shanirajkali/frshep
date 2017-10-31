var util={
	addListToSelect: function(id,list,model){
		var selectBox=document.getElementById(id);
    	for(var i=selectBox.length-1;i>=0;--i){
    		selectBox.remove(i);
    		console.log(i);
    	}
    	selectBox.SelectedIndex=-1;
    	for(var i=0;i<list.length;++i){
    		var option = document.createElement('option');
    		option.text = list[i];
    		option.value = list[i];
    		selectBox.add(option,i);
    	}
    	
    	
	}	
}