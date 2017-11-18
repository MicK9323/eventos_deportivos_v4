$(document).ready(function() {
    $('#formFicha').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	NomEquipo: {
        		validators: {
                    notEmpty: {
                        message: 'Campo Requerido'
                    },
                    stringLength:{
                    	max:50,
                    	message: '50 Caracteres Maximos'
                    }
                }
            },
            dniJugador: {
            	validators: {
                    numeric: {
                        message: 'Ingrese Solo Numeros'
                    },
                    stringLength:{
                        max:8,
                        min:8,
                        message: 'Ingrese Solo 8 Caracteres'
                    }
                }
            }
        }
    });
});
