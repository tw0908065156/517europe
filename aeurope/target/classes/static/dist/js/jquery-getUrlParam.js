/* Copyright (c) 2006-2007 Mathias Bank (http://www.mathias-bank.de)	
* Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php) 	
* and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.	
* Version 2.1	
* Thanks to 	
* Hinnerk Ruemenapf - http://hinnerk.ruemenapf.de/ for bug reporting and fixing.	
 * Tom Leonard for some improvements	
 */	

/**	
* Returns get parameters.	
* If the desired param does not exist, null will be returned	
* To get the document params:	
* @example value = jQuery(document).getUrlParam("paramName");	
* To get the params of a html-attribut (uses src attribute)	
* @example value = jQuery('#imgLink').getUrlParam("paramName");	
*/ 	
 
(function ($) { 
               $.getUrlParam = function (name) { 
                   var reg = new RegExp("(^|&amp;)" + name + "=([^&amp;]*)(&amp;|$)"); 
                   var r = window.location.search.substr(1).match(reg); 
                   if (r != null) return unescape(r[2]); return null; 
               } 
           })(jQuery);