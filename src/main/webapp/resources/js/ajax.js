/**
 * 
 */
function ajax(conf){
	conf.beforeSend = function(xhr){
		xhr.setRequestHeader('x-ajax','true');
	}
	$.ajax(conf);
}