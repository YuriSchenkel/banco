$("#enviar").click(cadastrarUsuario);

function cadastrarUsuario(){
	let nome = $("#nome").val();
	let matricula = $("#matricula").val();
	let email = $("#email").val();

	$.ajax({
		type: "POST",
		url: "/cadastro",
		data:{
			nome:nome,
			matricula:matricula,
			email:email,
			cargo:cargo,
		},
		success:function(data){
			alert("ok");
		},
		error: function(){
			alert("Não ok");
		}
	});
}