function carregaCompararPerfil(){

    var conteudoTwitter1 = document.getElementById('twitter1').innerText;
    var conteudoTwitter2 = document.getElementById('twitter2').innerText;



    if(!conteudoTwitter1 & !conteudoTwitter2){
        document.getElementById('IDdashboard').style.display = "inline";
    
        google.charts.load('current', {'packages':['line']});
        google.charts.setOnLoadCallback(drawVisualization);
    }
}

function drawChartCompara(perfilAnalisado1, perfilAnalisado2) {
	
	var perfil1Nome = $("#perfil1").val();
	var perfil2Nome = $("#perfil2").val();

	var data = new google.visualization.DataTable();
	data.addColumn('string', '');
	data.addColumn('number', perfil1Nome);
	data.addColumn('number', perfil2Nome);
	
	data.addRows([
        ['Aventureiro', perfilAnalisado1.aventureiro, perfilAnalisado2.aventureiro],
        ['Interesses Artístico', perfilAnalisado1.interesses_Artisticos, perfilAnalisado2.interesses_Artisticos],
        ['Emoção', perfilAnalisado1.emocao, perfilAnalisado2.emocao],
        ['Imaginação', perfilAnalisado1.imaginacao, perfilAnalisado2.imaginacao],
        ['Intelecto', perfilAnalisado1.intelecto, perfilAnalisado2.intelecto],
        ['Liberalismo', perfilAnalisado1.liberalismo, perfilAnalisado2.liberalismo]
    ]);

	var options = {
	    chart: { 
	          title: 'Abertura à novas experiências'
	    }, 
	    width: 800,
	    height: 400,
	    titleTextStyle:{ color: '#000000', fontSize: 20, bold: true}, 
	    fontSize:16,
	    color: '#000000',
	    hAxis: {title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true }},
	    vAxis: {title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true }}
	  };

	  var chart = new google.charts.Line(document.getElementById('comparaAbertura'));
	  chart.draw(data, google.charts.Line.convertOptions(options));


	// 2 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	var data1 = new google.visualization.DataTable();
	data1.addColumn('string', '');
	data1.addColumn('number', perfil1Nome);
	data1.addColumn('number', perfil2Nome);
	
	data1.addRows([
        ['Esforçado', perfilAnalisado1.esforcado, perfilAnalisado2.esforcado],
        ['Cuidadoso', perfilAnalisado1.cuidadoso, perfilAnalisado2.cuidadoso],
        ['Obediência', perfilAnalisado1.obediencia, perfilAnalisado2.obediencia],
        ['Comportamento', perfilAnalisado1.comportamento, perfilAnalisado2.comportamento],
        ['Disciplina', perfilAnalisado1.disciplina, perfilAnalisado2.disciplina],
        ['Eficácia', perfilAnalisado1.eficacia, perfilAnalisado2.eficacia]
    ]);

	var options1 = {
	    chart: { 
	          title: 'Consciência',
	    }, 
	    width: 800,
	    height: 400,
	    titleTextStyle:{ color: '#000000', fontSize: 20, bold: true}, 
	    fontSize:16,
	    color: '#000000',
	    hAxis: {title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true }},
	    vAxis: {title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true }}
	  };



	var chart1 = new google.charts.Line(document.getElementById('comparaConsciencia'));
	chart1.draw(data1, google.charts.Line.convertOptions(options1));

	// 3 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	var data2 = new google.visualization.DataTable();
	data2.addColumn('string', '');
	data2.addColumn('number', perfil1Nome);
	data2.addColumn('number', perfil2Nome);
	
	data2.addRows([
        ['Proatividade', perfilAnalisado1.proatividade, perfilAnalisado2.proatividade],
        ['Assertividade', perfilAnalisado1.assertividade, perfilAnalisado2.assertividade],
        ['Alegria', perfilAnalisado1.alegria, perfilAnalisado2.alegria],
        ['Procura de desafios', perfilAnalisado1.procura_de_desafios, perfilAnalisado2.procura_de_desafios],
        ['Simpatia', perfilAnalisado1.simpatia, perfilAnalisado2.simpatia],
        ['Social', perfilAnalisado1.social, perfilAnalisado2.social]
    ]);

	var options2 = {
	    chart: { 
	          title: 'Agradabilidade',
	    }, 
	    width: 800,
	    height: 400,
	    titleTextStyle:{ color: '#000000', fontSize: 20, bold: true}, 
	    fontSize:16,
	    color: '#000000',
	    hAxis: {title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true }},
	    vAxis: {title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true }}
	  };



	var chart2 = new google.charts.Line(document.getElementById('comparaAgradabilidade'));
	chart2.draw(data2, google.charts.Line.convertOptions(options2));

	// 4 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	var data3 = new google.visualization.DataTable();
	data3.addColumn('string', '');
	data3.addColumn('number', perfil1Nome);
	data3.addColumn('number', perfil2Nome);
	
	data3.addRows([
        ['Altruismo', perfilAnalisado1.altruismo, perfilAnalisado2.altruismo],
        ['Cooperação', perfilAnalisado1.cooperacao, perfilAnalisado2.cooperacao],
        ['Modestidade', perfilAnalisado1.modestidade, perfilAnalisado2.modestidade],
        ['Moralidade', perfilAnalisado1.moralidade, perfilAnalisado2.moralidade],
        ['Simpaticidade', perfilAnalisado1.simpaticidade, perfilAnalisado2.simpaticidade],
        ['Confiança', perfilAnalisado1.confianca, perfilAnalisado2.confianca]
    ]);
	
	var options3 = {
	    chart: { 
	          title: 'Extroversão',
	    }, 
	    width: 800,
	    height: 400,
	    titleTextStyle:{ color: '#000000', fontSize: 20, bold: true}, 
	    fontSize:16,
	    color: '#000000',
	    hAxis: {title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true }},
	    vAxis: {title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true }}
	  };



	var chart3 = new google.charts.Line(document.getElementById('comparaExtroversao'));
	chart3.draw(data3, google.charts.Line.convertOptions(options3));

	// 5 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	var data4 = new google.visualization.DataTable();
	data4.addColumn('string', '');
	data4.addColumn('number', perfil1Nome);
	data4.addColumn('number', perfil2Nome);
	
	data4.addRows([
        ['Raiva', perfilAnalisado1.raiva, perfilAnalisado2.raiva],
        ['Ansiedade', perfilAnalisado1.ansiedade, perfilAnalisado2.ansiedade],
        ['Depressão', perfilAnalisado1.depressao, perfilAnalisado2.depressao],
        ['Imoderação', perfilAnalisado1.imoderacao, perfilAnalisado2.imoderacao],
        ['Auto Consciência', perfilAnalisado1.auto_conciencia, perfilAnalisado2.auto_conciencia],
        ['Vulnerabilidade', perfilAnalisado1.vulnerabilidade, perfilAnalisado2.vulnerabilidade]
    ]);

	var options4 = {
	    chart: { 
	          title: 'Neuroticismo',
	    }, 
	    width: 800,
	    height: 400,
	    titleTextStyle:{ color: '#000000', fontSize: 20, bold: true}, 
	    fontSize:16,
	    color: '#000000',
	    hAxis: {title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true }},
	    vAxis: {title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true }}
	  };

	var chart4 = new google.charts.Line(document.getElementById('comparaNeuroticismo'));
	chart4.draw(data4, google.charts.Line.convertOptions(options4));

}

function drawVisualization(){
	p1 = $("#twitter1").val();
	p2 = $("#twitter2").val();
	
	$.get("/personalidade/analisa/" + p1, function (data) {
		perfilAnalisado1 = {
				aventureiro : data.fatores[0].dimensoes[0].porcentagem * 100,
		        interesses_Artisticos : data.fatores[0].dimensoes[1].porcentagem * 100,
		        emocao : data.fatores[0].dimensoes[2].porcentagem * 100,
		        imaginacao : data.fatores[0].dimensoes[3].porcentagem * 100,
		        intelecto : data.fatores[0].dimensoes[4].porcentagem * 100,
		        liberalismo : data.fatores[0].dimensoes[5].porcentagem * 100,

		        esforcado : data.fatores[1].dimensoes[0].porcentagem * 100,
		        cuidadoso : data.fatores[1].dimensoes[1].porcentagem * 100,
		        obediencia : data.fatores[1].dimensoes[2].porcentagem * 100,
		        comportamento : data.fatores[1].dimensoes[3].porcentagem * 100,
		        disciplina : data.fatores[1].dimensoes[4].porcentagem * 100,
		        eficacia : data.fatores[1].dimensoes[5].porcentagem * 100,

		        proatividade : data.fatores[2].dimensoes[0].porcentagem * 100,
		        assertividade : data.fatores[2].dimensoes[1].porcentagem * 100,
		        alegria : data.fatores[2].dimensoes[2].porcentagem * 100,
		        procura_de_desafios : data.fatores[2].dimensoes[3].porcentagem * 100,
		        simpatia : data.fatores[2].dimensoes[4].porcentagem * 100,
		        social : data.fatores[2].dimensoes[5].porcentagem * 100,

		        altruismo : data.fatores[3].dimensoes[0].porcentagem * 100,
		        cooperacao : data.fatores[3].dimensoes[1].porcentagem * 100,
		        modestidade : data.fatores[3].dimensoes[2].porcentagem * 100,
		        moralidade : data.fatores[3].dimensoes[3].porcentagem * 100,
		        simpaticidade : data.fatores[3].dimensoes[4].porcentagem * 100,
		        confianca : data.fatores[3].dimensoes[5].porcentagem * 100,

		        raiva : data.fatores[4].dimensoes[0].porcentagem * 100,
		        ansiedade : data.fatores[4].dimensoes[1].porcentagem * 100,
		        depressao : data.fatores[4].dimensoes[2].porcentagem * 100,
		        imoderacao : data.fatores[4].dimensoes[3].porcentagem * 100,
		        auto_conciencia : data.fatores[4].dimensoes[4].porcentagem * 100,
		        vulnerabilidade : data.fatores[4].dimensoes[5].porcentagem * 100
		};
				
		compararSegundoPerfil(perfilAnalisado1, p2);
    });
}

function compararSegundoPerfil(perfilAnalisado1, p2){
	$.get("/personalidade/analisa/" + p2, function (data) {
		perfilAnalisado2 = {
				aventureiro : data.fatores[0].dimensoes[0].porcentagem * 100,
		        interesses_Artisticos : data.fatores[0].dimensoes[1].porcentagem * 100,
		        emocao : data.fatores[0].dimensoes[2].porcentagem * 100,
		        imaginacao : data.fatores[0].dimensoes[3].porcentagem * 100,
		        intelecto : data.fatores[0].dimensoes[4].porcentagem * 100,
		        liberalismo : data.fatores[0].dimensoes[5].porcentagem * 100,

		        esforcado : data.fatores[1].dimensoes[0].porcentagem * 100,
		        cuidadoso : data.fatores[1].dimensoes[1].porcentagem * 100,
		        obediencia : data.fatores[1].dimensoes[2].porcentagem * 100,
		        comportamento : data.fatores[1].dimensoes[3].porcentagem * 100,
		        disciplina : data.fatores[1].dimensoes[4].porcentagem * 100,
		        eficacia : data.fatores[1].dimensoes[5].porcentagem * 100,

		        proatividade : data.fatores[2].dimensoes[0].porcentagem * 100,
		        assertividade : data.fatores[2].dimensoes[1].porcentagem * 100,
		        alegria : data.fatores[2].dimensoes[2].porcentagem * 100,
		        procura_de_desafios : data.fatores[2].dimensoes[3].porcentagem * 100,
		        simpatia : data.fatores[2].dimensoes[4].porcentagem * 100,
		        social : data.fatores[2].dimensoes[5].porcentagem * 100,

		        altruismo : data.fatores[3].dimensoes[0].porcentagem * 100,
		        cooperacao : data.fatores[3].dimensoes[1].porcentagem * 100,
		        modestidade : data.fatores[3].dimensoes[2].porcentagem * 100,
		        moralidade : data.fatores[3].dimensoes[3].porcentagem * 100,
		        simpaticidade : data.fatores[3].dimensoes[4].porcentagem * 100,
		        confianca : data.fatores[3].dimensoes[5].porcentagem * 100,

		        raiva : data.fatores[4].dimensoes[0].porcentagem * 100,
		        ansiedade : data.fatores[4].dimensoes[1].porcentagem * 100,
		        depressao : data.fatores[4].dimensoes[2].porcentagem * 100,
		        imoderacao : data.fatores[4].dimensoes[3].porcentagem * 100,
		        auto_conciencia : data.fatores[4].dimensoes[4].porcentagem * 100,
		        vulnerabilidade : data.fatores[4].dimensoes[5].porcentagem * 100
		};
				
		drawChartCompara(perfilAnalisado1, perfilAnalisado2);
    });
}

function drawChartCompara2(perfil1, perfil2) {
	
    var data = new google.visualization.DataTable();
    data.addColumn('string', '');
    data.addColumn('number', perfil1Nome);
    data.addColumn('number', perfil2Nome);

    data.addRows([
        ['Aventureiro', perfil1.aventureiro, perfil2.aventureiro],
        ['Interesses Artístico', perfil1.interesses_Artisticos, perfil2.interesses_Artisticos],
        ['Emoção', perfil1.emocao, perfil2.emocao],
        ['Imaginação', perfil1.imaginacao, perfil2.imaginacao],
        ['Intelecto', perfil1.intelecto, perfil2.imaginacao],
        ['Liberalismo', perfil1.liberalismo, perfil2.liberalismo]
    ]);

    var options = {
        chart: {
            title: 'Abertura à novas experiências'
        },
        width: 800,
        height: 400,
        titleTextStyle: { color: '#000000', fontSize: 20, bold: true },
        fontSize: 16,
        color: '#000000',
        hAxis: { title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true } },
        vAxis: { title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true } }
    };

    var chart = new google.charts.Line(document.getElementById('comparaAbertura'));
    chart.draw(data, google.charts.Line.convertOptions(options));

    // 2 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var data1 = new google.visualization.DataTable();
    data1.addColumn('string', '');
    data1.addColumn('number', perfil1Nome);
    data1.addColumn('number', perfil2Nome);

    data1.addRows([
        ['Esforçado', perfil1.esforcado, perfil2.esforcado],
        ['Cuidadoso', perfil1.cuidadoso, perfil2.cuidadoso],
        ['Obediência', perfil1.obediencia, perfil2.obediencia],
        ['Comportamento', perfil1.comportamento, perfil2.comportamento],
        ['Disciplina', perfil1.disciplina, perfil2.disciplina],
        ['Eficácia', perfil1.eficacia, perfil2.disciplina]
    ]);

    var options1 = {
        chart: {
            title: 'Consciência',
        },
        width: 800,
        height: 400,
        titleTextStyle: { color: '#000000', fontSize: 20, bold: true },
        fontSize: 16,
        color: '#000000',
        hAxis: { title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true } },
        vAxis: { title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true } }
    };

    var chart1 = new google.charts.Line(document.getElementById('comparaConsciencia'));
    chart1.draw(data1, google.charts.Line.convertOptions(options1));

    // 3 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var data2 = new google.visualization.DataTable();
    data2.addColumn('string', '');
    data2.addColumn('number', perfil1Nome);
    data2.addColumn('number', perfil2Nome);

    data2.addRows([
        ['Proatividade', perfil1.proatividade, perfil2.proatividade],
        ['Assertividade', perfil1.assertividade, perfil2.assertividade],
        ['Alegria', perfil1.alegria, perfil2.alegria],
        ['Procura de desafios', perfil1.procura_de_desafios, perfil2.procura_de_desafios],
        ['Simpatia', perfil1.simpatia, perfil2.simpatia],
        ['Social', perfil1.social, perfil2.social]
    ]);

    var options2 = {
        chart: {
            title: 'Agradabilidade',
        },
        width: 800,
        height: 400,
        titleTextStyle: { color: '#000000', fontSize: 20, bold: true },
        fontSize: 16,
        color: '#000000',
        hAxis: { title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true } },
        vAxis: { title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true } }
    };
    
    var chart2 = new google.charts.Line(document.getElementById('comparaAgradabilidade'));
    chart2.draw(data2, google.charts.Line.convertOptions(options2));

    // 4 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var data3 = new google.visualization.DataTable();
    data3.addColumn('string', '');
    data3.addColumn('number', perfil1Nome);
    data3.addColumn('number', perfil2Nome);

    data3.addRows([
        ['Altruismo', perfil1.altruismo, perfil2.altruismo],
        ['Cooperação', perfil1.cooperacao, perfil2.cooperacao],
        ['Modestidade', perfil1.modestidade, perfil2.modestidade],
        ['Moralidade', perfil1.moralidade, perfil2.moralidade],
        ['Simpaticidade', perfil.simpaticidade, perfi2.simpaticidade],
        ['Confiança', perfil1.confianca, perfil2.confianca]
    ]);
    
    var options3 = {
        chart: {
            title: 'Extroversão',
        },
        width: 800,
        height: 400,
        titleTextStyle: { color: '#000000', fontSize: 20, bold: true },
        fontSize: 16,
        color: '#000000',
        hAxis: { title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true } },
        vAxis: { title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true } }
    };

    var chart3 = new google.charts.Line(document.getElementById('comparaExtroversao'));
    chart3.draw(data3, google.charts.Line.convertOptions(options3));

    // 5 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var data4 = new google.visualization.DataTable();
    data4.addColumn('string', '');
    data4.addColumn('number', perfil1Nome);
    data4.addColumn('number', perfil2Nome);

    data4.addRows([
        ['Raiva', perfil1.raiva, perfil2.raiva],
        ['Ansiedade', perfil1.ansiedade, perfil2.ansiedade],
        ['Depressão', perfil1.depressao, perfil2.depressao],
        ['Imoderação', perfil1.imoderacao, perfil2.imoderacao],
        ['Auto Consciência', perfil1.auto_conciencia, perfil2.auto_conciencia],
        ['Vulnerabilidade', perfil1.vulnerabilidade, perfil2.vulnerabilidade]
    ]);
    
    var options4 = {
        chart: {
            title: 'Neuroticismo',
        },
        width: 800,
        height: 400,
        titleTextStyle: { color: '#000000', fontSize: 20, bold: true },
        fontSize: 16,
        color: '#000000',
        hAxis: { title: 'Personalidade', titleTextStyle: { color: '#3a6d66', fontSize: 16, bold: true } },
        vAxis: { title: '%', titleTextStyle: { color: '#3a6d66', fontSize: 16, minValue: 0, maxValue: 100, bold: true } }
    };

    var chart4 = new google.charts.Line(document.getElementById('comparaNeuroticismo'));
    chart4.draw(data4, google.charts.Line.convertOptions(options4));
}