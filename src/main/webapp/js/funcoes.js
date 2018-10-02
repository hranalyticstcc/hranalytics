function entrar()
{
    
    var nome = document.getElementById('IDnomeUsuario').value;
    var password = document.getElementById('IDsenhaUsuario').value;

    
    if (nome == 'Aline' & password == '123')
    {
        window.location="paginaInicial.html";
    }
    else
    {
        alert("Senha Inválida");
    }
}

function cadastrar()
{
    window.location="cadastroUsuario.html";
}



/******************************* Cadastrar novo usuário ***************************************************/
function formatarCpf(evt)
{
    vr = (Navigator.appName == 'Netscape') ?evt.target.value : evt.srcElement.value;
        if(vr.length == 3) vr = vr+".";
        if(vr.length == 7) vr = vr+".";
        if(vr.length == 11) vr = vr+"-";
    return vr;
}

function formatarTelefone(evt)
{
    vr = (Navigator.appName == 'Netscape') ?evt.target.value : evt.srcElement.value;
        if(vr.length == 0) vr = vr+"(";
        if(vr.length == 3) vr = vr+")";
        if(vr.length == 9) vr = vr+"-";
    return vr;
}

function formatarCnpj(evt)
{
    vr = (Navigator.appName == 'Netscape') ?evt.target.value : evt.srcElement.value;
        if(vr.length == 2) vr = vr+".";
        if(vr.length == 6) vr = vr+".";
        if(vr.length == 10) vr = vr+"/";
        if(vr.length == 15) vr = vr+"-";
    return vr;
}
 

function validarCPF(cpf) {

    /*Desformatar campo cpf*/    
    cpf = cpf.replace(".", "");
    cpf = cpf.replace(".", "");
    cpf = cpf.replace("-", "");
 
    var numeros, digitos, soma, i, resultado, digitos_iguais;
    digitos_iguais = 1;
    if (cpf.length < 11)
          return false;
    for (i = 0; i < cpf.length - 1; i++)
          if (cpf.charAt(i) != cpf.charAt(i + 1))
                {
                digitos_iguais = 0;
                break;
                }
    if (!digitos_iguais)
          {
          numeros = cpf.substring(0,9);
          digitos = cpf.substring(9);
          soma = 0;
          for (i = 10; i > 1; i--)
                soma += numeros.charAt(10 - i) * i;
          resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
          if (resultado != digitos.charAt(0))
                return false;
          numeros = cpf.substring(0,10);
          soma = 0;
          for (i = 11; i > 1; i--)
                soma += numeros.charAt(11 - i) * i;
          resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
          if (resultado != digitos.charAt(1))
                return false;
          return true;
          }
    else
        return false;
}

function validarCamposObrigatorios(nomePessoaFisica, emailPessoaFisica,cpfPessoaFisica,telefone1,cnpj,usuario,senha1,senha2){

        /*Tirando as bordas vermelhas para quando for revalidar*/
       document.getElementById('IDnomePessoaFisica').style.border  = '1px solid transparent';
       document.getElementById('IDemailPessoaFisica').style.border = '1px solid transparent';
       document.getElementById('IDcpfPessoaFisica').style.border   = '1px solid transparent';
       document.getElementById('IDtelefone1').style.border         = '1px solid transparent'; 
       document.getElementById('IDcnpj').style.border              = '1px solid transparent';
       document.getElementById('IDusuario').style.border           = '1px solid transparent';
       document.getElementById('IDsenha').style.border             = '1px solid transparent';
       document.getElementById('IDconfirmarSenha').style.border    = '1px solid transparent';


    if (nomePessoaFisica == '' || emailPessoaFisica == '' || cpfPessoaFisica == '' || telefone1 == '' || cnpj == '' || usuario == '' || senha1 =='' || senha2 == '')
    {
        alert("Campo(s) obrigatório(s) não preenchido(s)");
        
        if (nomePessoaFisica == '')  document.getElementById('IDnomePessoaFisica').style.border  = 'solid 1px red';
        if (emailPessoaFisica == '') document.getElementById('IDemailPessoaFisica').style.border = 'solid 1px red';
        if (cpfPessoaFisica == '')   document.getElementById('IDcpfPessoaFisica').style.border   = 'solid 1px red';
        if (telefone1 == '')         document.getElementById('IDtelefone1').style.border         = 'solid 1px red'; 
        if (cnpj == '')              document.getElementById('IDcnpj').style.border              = 'solid 1px red'; 
        if (usuario == '')           document.getElementById('IDusuario').style.border           = 'solid 1px red'; 
        if (senha1 == '')            document.getElementById('IDsenha').style.border             = 'solid 1px red'; 
        if (senha2 == '')            document.getElementById('IDconfirmarSenha').style.border    = 'solid 1px red'; 

        return false;
    }

    else 
        return true;

}


function validarSenha(senha1, senha2){

    if(senha1 == senha2) return true;
    else return false;

}

function msgCampos(cpf, senha)
{
        if(cpf == false){    
            var div = document.getElementById("msgCpf");
            div.textContent = " Cpf inválido";
        }

        if(senha == false){
            var div = document.getElementById("msgSenha");
            div.textContent = "As senhas estão diferentes";
        }


        /* Limpar a mensagem dos campos */
        if(cpf == true){    
            var div = document.getElementById("msgCpf");
            div.textContent = " ";
        }

        if(senha == true){
            var div = document.getElementById("msgSenha");
            div.textContent = " ";
        }


}

function finalizarCadastro()
{
    /* Verificar campos obrigatórios */
    var nomePessoaFisica  = document.getElementById('IDnomePessoaFisica').value;
    var emailPessoaFisica = document.getElementById('IDemailPessoaFisica').value;
    var cpfPessoaFisica   = document.getElementById('IDcpfPessoaFisica').value;
    var telefone1         = document.getElementById('IDtelefone1').value;
    var cnpj              = document.getElementById('IDcnpj').value;
    var usuario           = document.getElementById('IDusuario').value;
    var senha1            = document.getElementById('IDsenha').value;
    var senha2            = document.getElementById('IDconfirmarSenha').value;


    var campos = validarCamposObrigatorios(nomePessoaFisica, emailPessoaFisica,cpfPessoaFisica,telefone1,cnpj,usuario,senha1,senha2);
    var cpf    = validarCPF(cpfPessoaFisica);
    var senha  = validarSenha(senha1, senha2);

    
    if(campos== true & (cpf == false || senha == false)){
        alert("Informação inválida, favor verifique.");
    }
    
    if(campos == true & cpf == true & senha == true){

        alert("Cadastro realizado com sucesso !\n"+
              "\n Nome: "+nomePessoaFisica+
              "\n E-mail: "+emailPessoaFisica+
              "\n Cpf: "+cpfPessoaFisica+
              "\n Telefone: "+telefone1+
              "\n Cnpj: "+cnpj+
              "\n Usuário: "+usuario+
              "\n Senha 1: "+senha1+
              "\n Senha 2: "+senha2)
    }
    
        msgCampos(cpf, senha);
    
}

/******************************* Dashboard ************************************************************************/
function validaUsuarioTweeter(usuarioTweeter)
{
    var usuarioTweeter2 = document.getElementById('usuarioTweeter').value;
    
    if(usuarioTweeter2 == '')
    {
       
        alert('Este campo é obrigatório, favor preencher e tentar novamente!')
        
    }
    else{

        alert ("Busca realizada com sucesso, verifique abaixo o DashBoard!\n"+
        "\n Usuário: "+usuarioTweeter2);

        carregarDashBoard();

    }
}


function carregarDashBoard() {
    //document.getElementById('IDdashboard').style.display = 'none';
    document.getElementById('IDdashboard').style.color = 'black';
        
    google.charts.load("current", { packages: ['corechart'] });
    google.charts.setOnLoadCallback(drawChart);
}

function drawChart() {

    var perfil = document.getElementById('usuarioTweeter').value;

    $.get("/personalidade/analisa/" + perfil, function (data) {

        var aventureiro = data.bigFive[0].filhos[0].porcentagem * 100;
        var interesses_Artisticos = data.bigFive[0].filhos[1].porcentagem * 100;
        var emocao = data.bigFive[0].filhos[2].porcentagem * 100;
        var imaginacao = data.bigFive[0].filhos[3].porcentagem * 100;
        var intelecto = data.bigFive[0].filhos[4].porcentagem * 100;
        var liberalismo = data.bigFive[0].filhos[5].porcentagem * 100;
        drawSentimentos(aventureiro, interesses_Artisticos, emocao, imaginacao, intelecto, liberalismo);

        var esforcado = data.bigFive[1].filhos[0].porcentagem * 100;
        var cuidadoso = data.bigFive[1].filhos[1].porcentagem * 100;
        var obediencia = data.bigFive[1].filhos[2].porcentagem * 100;
        var comportamento = data.bigFive[1].filhos[3].porcentagem * 100;
        var disciplina = data.bigFive[1].filhos[4].porcentagem * 100;
        var eficacia = data.bigFive[1].filhos[5].porcentagem * 100;
        drawConsciencia(esforcado, cuidadoso, obediencia, comportamento, disciplina, eficacia);

        var proatividade = data.bigFive[2].filhos[0].porcentagem * 100;
        var assertividade = data.bigFive[2].filhos[1].porcentagem * 100;
        var alegria = data.bigFive[2].filhos[2].porcentagem * 100;
        var procura_de_desafios = data.bigFive[2].filhos[3].porcentagem * 100;
        var simpatia = data.bigFive[2].filhos[4].porcentagem * 100;
        var social = data.bigFive[2].filhos[5].porcentagem * 100;
        drawExtroversao(proatividade, assertividade, alegria, procura_de_desafios, simpatia, social);

        var altruismo = data.bigFive[3].filhos[0].porcentagem * 100;
        var cooperacao = data.bigFive[3].filhos[1].porcentagem * 100;
        var modestidade = data.bigFive[3].filhos[2].porcentagem * 100;
        var moralidade = data.bigFive[3].filhos[3].porcentagem * 100;
        var simpaticidade = data.bigFive[3].filhos[4].porcentagem * 100;
        var confianca = data.bigFive[3].filhos[5].porcentagem * 100;
        drawAgregabilidade(altruismo, cooperacao, modestidade, moralidade, simpaticidade, confianca);

        var raiva = data.bigFive[4].filhos[0].porcentagem * 100;
        var ansiedade = data.bigFive[4].filhos[1].porcentagem * 100;
        var depressao = data.bigFive[4].filhos[2].porcentagem * 100;
        var imoderacao = data.bigFive[4].filhos[3].porcentagem * 100;
        var auto_conciencia = data.bigFive[4].filhos[4].porcentagem * 100;
        var vulnerabilidade = data.bigFive[4].filhos[5].porcentagem * 100;
        drawNeuroticismo(raiva, ansiedade, depressao, imoderacao, auto_conciencia, vulnerabilidade);
    })
}

function drawSentimentos(aventureiro,interesses_Artisticos, emocao, imaginacao, intelecto, liberalismo){
    //sentimentos------------------------------------------------------------------
    var data1 = google.visualization.arrayToDataTable([
        ["Elemento", "Densidade", { role: "style" }],
        ["Aventureiro", aventureiro, "green"],
        ["Interesses Artísticos", interesses_Artisticos, "orange"],
        ["Emoção", emocao, "red"],
        ["Imaginação", imaginacao, "blue"],
        ["Intelecto", intelecto, "bronze"],
        ["Liberalismo", liberalismo, "yellow"]
    ]);

    var view1 = new google.visualization.DataView(data1);
    view1.setColumns([0, 1,
        {
            calc: "stringify",
            sourceColumn: 1,
            type: "string",
            role: "annotation"
        },
        2]);
    var options1 = {
        title: "Sentimentos",
        width: 550,
        height: 400,
        bar: { groupWidth: "95%" },
        legend: { position: "none" },
    };

    var chart1 = new google.visualization.ColumnChart(document.getElementById("columnchart_values1"));
    chart1.draw(view1, options1);
}

function drawConsciencia(esforcado, cuidadoso, obediencia, comportamento, disciplina, eficacia){
    //consciencia
    var data2 = google.visualization.arrayToDataTable([
        ["Elemento", "Densidade", { role: "style" }],
        ["Esforçado", esforcado, "#yellow"],
        ["Cuidadoso", cuidadoso, "purple"],
        ["Obediência", obediencia, "blue"],
        ["Comportamento", comportamento, "red"],
        ["Disciplina", disciplina, "orange"],
        ["Eficácia", eficacia, "green"]
    ]);

    var view2 = new google.visualization.DataView(data2);
    view2.setColumns([0, 1,
        {
            calc: "stringify",
            sourceColumn: 1,
            type: "string",
            role: "annotation"
        },
        2]);

    var options2 = {
        title: "Consciência",
        width: 550,
        height: 400,
        bar: { groupWidth: "95%" },
        legend: { position: "none" },
    };

    var chart2 = new google.visualization.ColumnChart(document.getElementById("columnchart_values2"));
    chart2.draw(view2, options2);
}

function drawExtroversao(proatividade, assertividade, alegria, procura_de_desafios, simpatia, social){
    //extroversao
    var data3 = google.visualization.arrayToDataTable([
        ["Elemento", "Densidade", { role: "style" }],
        ["Proatividade", proatividade, "#yellow"],
        ["Assertividade", assertividade, "purple"],
        ["Alegria", alegria, "blue"],
        ["Procura de desafios", procura_de_desafios, "red"],
        ["Simpatia", simpatia, "orange"],
        ["Social", social, "green"]
    ]);

    var view3 = new google.visualization.DataView(data3);
    view3.setColumns([0, 1,
        {
            calc: "stringify",
            sourceColumn: 1,
            type: "string",
            role: "annotation"
        },
        2]);

    var options3 = {
        title: "Extroversão",
        width: 550,
        height: 400,
        bar: { groupWidth: "95%" },
        legend: { position: "none" },
    };

    var chart3 = new google.visualization.ColumnChart(document.getElementById("columnchart_values3"));
    chart3.draw(view3, options3);

}

function drawAgregabilidade(altruismo, cooperacao, modestidade, moralidade, simpaticidade, confianca){
    //agregabilidade
    var data4 = google.visualization.arrayToDataTable([
        ["Elemento", "Densidade", { role: "style" }],
        ["Altruismo", altruismo, "#yellow"],
        ["Cooperçcao", cooperacao, "purple"],
        ["Modestidade", modestidade, "blue"],
        ["Moralidade", moralidade, "red"],
        ["Simpaticidade", simpaticidade, "orange"],
        ["Confiança", confianca, "green"]
    ]);

    var view4 = new google.visualization.DataView(data4);
    view4.setColumns([0, 1,
        {
            calc: "stringify",
            sourceColumn: 1,
            type: "string",
            role: "annotation"
        },
        2]);

    var options4 = {
        title: "Agregabilidade",
        width: 550,
        height: 400,
        bar: { groupWidth: "95%" },
        legend: { position: "none" },
    };

    var chart4 = new google.visualization.ColumnChart(document.getElementById("columnchart_values4"));
    chart4.draw(view4, options4);
}

function drawNeuroticismo(raiva, ansiedade, depressao, imoderacao, auto_conciencia, vulnerabilidade){
    //Neuroticismo
    var data5 = google.visualization.arrayToDataTable([
        ["Elemento", "Densidade", { role: "style" }],
        ["Raiva", raiva, "#yellow"],
        ["Ansiedade", ansiedade, "purple"],
        ["Depressão", depressao, "blue"],
        ["Imoderacao", imoderacao, "red"],
        ["Auto Conciência", auto_conciencia, "orange"],
        ["Vulnerabilidade", vulnerabilidade, "green"]
    ]);

    var view5 = new google.visualization.DataView(data5);
    view5.setColumns([0, 1,
        {
            calc: "stringify",
            sourceColumn: 1,
            type: "string",
            role: "annotation"
        },
        2]);

    var options5 = {
        title: "Neuroticismo",
        width: 550,
        height: 400,
        bar: { groupWidth: "95%" },
        legend: { position: "none" },
    };

    var chart5 = new google.visualization.ColumnChart(document.getElementById("columnchart_values5"));
    chart5.draw(view5, options5);

}