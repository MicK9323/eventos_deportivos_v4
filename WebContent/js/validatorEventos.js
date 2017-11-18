$(document).ready(function() {

  var inscripcionInicio;
  var inscripcionFin;
  var eventoinicio;
  var eventoFin;
  var modalidadInicio;
  var modalidadFin;
  var minimo;
  var maximo;
  var varones;
  var mujeres;

  $('#inicioInscripcion').change(function(){//---DETECTAR CAMBIO DE VALOR
    inscripcionInicio = $(this).val();
    $('#formEvento').bootstrapValidator('updateOption','finInscripcion','date','min',inscripcionInicio);
    $('#formEvento').bootstrapValidator('revalidateField','finInscripcion');
  })
  $('#finInscripcion').change(function(){//---DETECTAR CAMBIO DE VALOR
    inscripcionFin = $(this).val();
    $('#formEvento').bootstrapValidator('updateOption','inicioEvento','date','min',inscripcionFin);
    $('#formEvento').bootstrapValidator('revalidateField','inicioEvento');
  })
  $('#inicioEvento').change(function(){//---DETECTAR CAMBIO DE VALOR
    eventoinicio = $(this).val();
    $('#formEvento').bootstrapValidator('updateOption','finEvento','date','min',eventoinicio);
    $('#formEvento').bootstrapValidator('updateOption','inicioModalidad','date','min',eventoinicio);
    $('#formEvento').bootstrapValidator('revalidateField','finEvento');
    $('#formEvento').bootstrapValidator('revalidateField','inicioModalidad');
  })
  $('#finEvento').change(function(){//---DETECTAR CAMBIO DE VALOR
    eventoFin = $(this).val();
    $('#formEvento').bootstrapValidator('updateOption','inicioModalidad','date','max',eventofin);
    $('#formEvento').bootstrapValidator('updateOption','finModalidad','date','max',eventofin);
    $('#formEvento').bootstrapValidator('revalidateField','inicioModalidad');
    $('#formEvento').bootstrapValidator('revalidateField','finModalidad');
  })
  $('#inicioModalidad').change(function(){//---DETECTAR CAMBIO DE VALOR
    modalidadInicio = $(this).val();
    $('#formEvento').bootstrapValidator('updateOption','finModalidad','date','min',modalidadInicio);
    $('#formEvento').bootstrapValidator('revalidateField','finModalidad');
  })
  $('#finModalidad').change(function(){//---DETECTAR CAMBIO DE VALOR
    modalidadFin = $(this).val();
  })
  $('#minIntegrantes').change(function(){//---DETECTAR CAMBIO DE VALOR
    minimo = $(this).val();
    $('#formEvento').bootstrapValidator('updateOption','maxIntegrantes','greaterThan','value',minimo);
    $('#formEvento').bootstrapValidator('revalidateField','maxIntegrantes');
  })
  $('#maxIntegrantes').change(function(){//---DETECTAR CAMBIO DE VALOR
    maximo = $(this).val();
    $('#formEvento').bootstrapValidator('updateOption','cantMujeres','lessThan','value',maximo);
    $('#formEvento').bootstrapValidator('updateOption','cantVarones','lessThan','value',maximo);
    $('#formEvento').bootstrapValidator('revalidateField','cantMujeres');
    $('#formEvento').bootstrapValidator('revalidateField','cantVarones');
  })
  $('#cantMujeres').change(function(){//---DETECTAR CAMBIO DE VALOR
    mujeres = $(this).val();
  })
  $('#cantVarones').change(function(){//---DETECTAR CAMBIO DE VALOR
    mujeres = $(this).val();
  })

  $('#formEvento').bootstrapValidator({
    feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
    },
    submitButtons: {
              selector: '#:not([formnovalidate])',
              disabled: ''
    },
    fields:{
      nomEvento:{
        selector:'#nomEvento',
        validators:{
          notEmpty:{
            message:'Campo Requerido*'
          },
          stringLength:{
            min: 3,
            max: 30,
            message: 'El nombre debe contener más de 3 y menos de 30 caracteres'
          },
          regexp:{
            regexp: /^[a-zA-ZñÑÁÉÍÓÚ\s]+$/,
            message: 'Este campo solo puede contener letras'
          }
        }
      },
      inicioInscripcion:{
        selector:'#inicioInscripcion',
        validators:{
          notEmpty:{
            message:'Campo Requerido*'
          }
        }
      },
      finInscripcion:{
        selector:'#finInscripcion',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          date:{
            min: inscripcionInicio,
            message: 'Debe ser posterior al inicio de inscripcion*'
          }
        }
      },
      inicioEvento:{
        selector:'#inicioEvento',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          date:{
            min: inscripcionFin,
            message: 'Debe ser posterior al fin de inscripcion*'
          }
        }
      },
      finEvento:{
        selector:'#finEvento',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          date:{
            min: eventoinicio,
            message: 'Debe ser posterior al fin de inscripcion*'
          }
        }
      },
      inicioModalidad:{
        selector:'#inicioModalidad',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          date:{
            min: eventoinicio,
            max: eventoFin,
            message: 'Fecha fuera de rango*'
          }
        }
      },
      finModalidad:{
        selector:'#finModalidad',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          date:{
            min: modalidadInicio,
            max: eventoFin,
            message: 'Fecha fuera de rango*'
          }
        }
      },
      minIntegrantes:{
        selector:'#minIntegrantes',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos'
          }
        }
      },
      maxIntegrantes:{
        selector:'#maxIntegrantes',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          greaterThan:{
            value: minimo,
            message: 'Debe ser mayor o igual al mínimo de integrantes'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos'
          }
        }
      },
      cantMujeres:{
        selector:'#cantMujeres',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos'
          }
        }
      },
      cantVarones:{
        selector:'#cantVarones',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          lessThan:{
            value: mayores,
            message: 'No debe exceder del maximo de integrantes'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos'
          }
        }
      },
      nroEquipos:{
        selector:'#nroEquipos',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos'
          }
        }
      }
    }
  })

});
