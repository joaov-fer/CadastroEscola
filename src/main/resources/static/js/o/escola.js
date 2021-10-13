

function searchViaAjax(id) {

    $.ajax({
        type : "GET",
        contentType : "application/json",
        url : "escola/r/" + id,
        dataType : 'json',
        success : function(data) {
            console.log("Data: ", data);
            $('#editId').val(data.id);
            $('#editNome').val(data.nome);
            $('#editFundacao').val(data.fundacao);
            
        },
        error : function(e) {
            console.log("ERROR: ", e);

        }
    });

}

function openModalDelete(idReg) {

        console.log(idReg);
        var id = $("#btnDeleteTable" + idReg).attr('data-id');
        var nome = $("#btnDeleteTable" + idReg).attr('data-nome');

        $('#excluirEscola').attr('href','/escola/delete/'+id+'');
        $('#bodyModalDelete span').text(nome);

}


$('document').ready(function(){
    
    $('#btnDeleteTable').on('click', function(event){
        
        console.log("test");
        console.log($(this).attr('data-id'));
        var id = $(this).attr('data-id');
        var nome = $(this).attr('data-nome');

        $('#excluirEscola').attr('href','/escola/delete/'+id+'');
        $('#bodyModalDelete span').text(nome);
        

   });
   
   
});


