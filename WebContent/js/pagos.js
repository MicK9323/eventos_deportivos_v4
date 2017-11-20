$(document).ready(function() {
  Culqi.publicKey = 'pk_test_XZ8r8Be2zGAKH52R';
  var monto = $('#monto').val();
  var ficha;
  
  Culqi.settings({
        title: 'Eventos Deportivos',
        currency: 'PEN',
        description: 'Derecho de Inscripcion',
        amount: monto
      });

  $('#btnPagar').click(function(){
    Culqi.open();
    e.preventDefault();
  })

  function culqi() {

    if(Culqi.token) { // ¡Token creado exitosamente!
        // Get the token ID:
        var token = Culqi.token.id;
        alert('Se ha creado un token:'.token);

    }else{ // ¡Hubo algún problema!
        // Mostramos JSON de objeto error en consola
        console.log(Culqi.error);
        alert(Culqi.error.mensaje);
    }
};


});
