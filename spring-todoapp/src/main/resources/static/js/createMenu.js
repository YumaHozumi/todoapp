'use strict'

window.onload = () => {
	const select = document.getElementById('timeSche');
	const hours = 24;
	const kugiri = 4;
	const minutes = 60;
	let text;
	for(let i = 0; i < hours; i++){
		for(let j = 0; j < kugiri; j++){
			let elem = document.createElement('option');
			text = "";
			if(i < 10){
				text += "0" + i + ":";
			}else{
				text += i + ":";
			}
			if(j === 0){
				text += "00";
			}else{
				text += (minutes / kugiri) * j;
			}
			elem.value = text;
			elem.textContent = text;
			if(task.timeSche === text){
				elem.selected = true;
			}
			select.appendChild(elem);
		}
	}
	
}