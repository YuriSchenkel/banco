$("#enviar").click(enviarDeposito);

function enviarDeposito(){
	let saldo = $("#saldo").val();

	$.ajax({
		type: "POST",
		url: "/deposito",
		data:{
			saldo:saldo,
		},
		success:function(data){
			alert("ok");
		},
		error: function(){
			alert("Não ok");
		}
	});
}