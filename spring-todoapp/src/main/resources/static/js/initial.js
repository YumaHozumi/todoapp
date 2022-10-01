'use strict'

let tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle]="tooltip"]'));
let tooltipList = tooltipTriggerList.map(function (tooltipTriggerElem){
	return new bootstrap.Tooltip(tooltipTriggerElem)
});