'use strict'

let popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'));
let popoverList = popoverTriggerList.map(function (popoverTriggerElem){
	return new bootstrap.Popover(popoverTriggerElem);
});