$("#enviarMenor").click(cadastrarUsuario);

function cadastrarUsuario(){
	let nome = $("#nome").val();
	let idade = $("#idade").val();
	let cpf = $("#cpf").val();
	let telefone = $("#telefone").val();
	let cep = $("#cep").val();
	let email = $("#email").val();
	let senha = $("#senha").val();

	$.ajax({
		type: "POST",
		url: "/cadastro",
		data:{
			nome:nome,
			idade:idade,
			cpf:cpf,
			telefone:telefone,
			cep:cep,
			email:email,
			senha:senha
		},
		success:function(data){
			alert("ok");
		},
		error: function(){
			alert("Não ok");
		}
	});
}

$("#enviarMaior").click(cadastrarUsuario);

function cadastrarUsuario(){
	let nome = $("#nome").val();
	let idade = $("#idade").val();
	let cpf = $("#cpf").val();
	let telefone = $("#telefone").val();
	let cep = $("#cep").val();
	let email = $("#email").val();
	let senha = $("#senha").val();

	$.ajax({
		type: "POST",
		url: "/cadastro",
		data:{
			nome:nome,
			idade:idade,
			cpf:cpf,
			telefone:telefone,
			cep:cep,
			email:email,
			senha:senha
		},
		success:function(data){
			alert("ok");
		},
		error: function(){
			alert("Não ok");
		}
	});
}