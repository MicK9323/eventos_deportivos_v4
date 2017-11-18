$(document).ready(function(){

  (function ($) {

                  $('#buscador').keyup(function () {

                      var rex = new RegExp($(this).val(), 'i');
                      $('.buscar .cuadro').hide();
                      $('.buscar .cuadro').filter(function () {
                          return rex.test($(this).text());
                      }).show();

                  })

              }(jQuery));




});
