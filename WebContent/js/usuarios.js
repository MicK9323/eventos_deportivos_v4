$(document).ready(function() {

  $('#fecNacimiento').datepicker({
    autoclose: true
  });

  $('#subirImagen').change(function(){
     readImgUrlAndPreview(this);
     function readImgUrlAndPreview(input){
        if (input.files && input.files[0]) {
                 var reader = new FileReader();
                 reader.onload = function (e) {
                     $('#imagePreview').attr('src', e.target.result);
             }
               };
               reader.readAsDataURL(input.files[0]);
          }
   });
});
