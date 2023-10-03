$("#enviar").click(enviarLogin);

function enviarLogin(){
	let cpf = $("#cpf").val();
    let senha = $("#senha").val();

	$.ajax({
		type: "POST",
		url: "/login",
		data:{
			cpf:cpf,
            senha:senha,
		},
		success:function(data){
			if(data){
			    window.location.href="/home"
			} else {
			    alert("Não ok");
			}
		},
		error: function(){
			alert("Não ok");
		}
	});
}