$(document).ready(function() {

  $('#fecNac').datepicker({
    autoclose: true
  });
  
  $('#fecNac').change(function(){
	  $('#edad').val(setEdad());
  })

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
  
  //Convertir password
  $('#clave').attr('type', 'password');


  
  //Solo Números
  $('#dni, #edad, #telfFijo, #telfMovil').on('input', function () { 
	    this.value = this.value.replace(/[^0-9]/g,'');
	});
  
  //Maximo valor del input
  $("#dni").attr("maxlength", 8);
  $("#edad").attr("maxlength", 2);
  $("#telfFijo").attr("maxlength", 10);
  $("#telfMovil").attr("maxlength", 10);
  $("#direccion").attr("maxlength", 45);
  $("#dirUsuario").attr("maxlength", 45);
  $("#email").attr("maxlength", 45);
  $("#nombre").attr("maxlength", 30);
  $("#apellido").attr("maxlength", 30);
  
  //Mascara para fecha
  $('#fecNac').mask('9999-99-99');
  	
  
  //Solo Letras
  $("#nombre,#apellido ").keypress(function(event){
      var inputValue = event.which;
      if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
          event.preventDefault();
      }
  });
  
  
  //SETEAR EDAD SEGUN AÑO
  function setEdad(){
		var fechaNac = $('#fecNac').val();
		var fecha 	 = new Date();
		var ano 	 = fecha.getFullYear();

		fechaNac = fechaNac.substr(0,4);
		var edad = parseInt(ano)- parseInt(fechaNac);
		return edad;
	}
  
  ValidarCombos = function(){};
	  
  
  $('#guardar').click(function() {
		 if ($('#sexo').val() == '-1') {
			alert("Seleccione Sexo");
			return;
		}
		 else if ($('#estCivil').val() == '-1') {
			alert("Seleccione su Estado Civil");
			return;
		}
		 else if ($('#jugador_codSede').val() == '-1') {
			alert("Seleccione su Sede");
			return;
		}
		 else if ($('#jugador_idRol').val() == '-1') {
			alert("Seleccione su Perfil");
			return;
		} 
  });
  
});
