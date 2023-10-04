$("#enviar").click(cadastrarResponsavel);

function cadastrarResponsavel(){
	let nome = $("#nome").val();
	let idade = $("#idade").val();
	let cpf = $("#cpf").val();
	let telefone = $("#telefone").val();
	let email = $("#email").val();

	$.ajax({
		type: "POST",
		url: "/cadastroResponsavel",
		data:{
			nome:nome,
			idade:idade,
			cpf:cpf,
			telefone:telefone,
			email:email,
		},
		success:function(data){
			alert("ok");
		},
		error: function(){
			alert("Não ok");
		}
	});
}