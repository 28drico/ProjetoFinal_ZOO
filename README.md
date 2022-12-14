
<h1 align="center"> ANIMAIS DE ZOOLOGICO</h1>

![Imagem de Logo.](https://user-images.githubusercontent.com/110492423/187594502-1922b051-7510-4b4c-bba8-e878a0f0c95e.png)

## VERSÃO DO APLICATIVO: 1.0

## DESCRIÇÃO DO PROJETO:

O aplicativo tem como objetivo facilitar na busca e conhecimento dos tipos de animais e suas caracteristicas.
Podendo ser acessado de um aparelho móvel, a qualquer hora e local. Além disso, permite também salvar os animais preferidos na lista de favoritos.

## STATUS DO PROJETO:

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## LINK FIGMA DO PROJETO:
<a href="https://www.figma.com/proto/fkcWL1cqUN7vIXWrdrmLcS/ZOO-(Copy)?node-id=0%3A1" target="_blank">ACESSE PROTÓTIPO NAVEGAVÉL PLATAFORMA FIGMA</a>


## FUNCIONALIDADES E DEMONSTRAÇÃO DA APLICAÇÃO:

PRINCIPAIS FUNCIONALIDADES:

○ Acesso de lista dos animais 

○ Adicionar itens ao animal

○ Criação de lista de animais favoritos


![Video_220831025728](https://user-images.githubusercontent.com/110492423/187604989-a276554f-f3ab-4a83-a661-2d7bba8e4d3f.gif)


## ACESSO AO APLICATIVO:

Em breve disponivel na play store android de seu celular

## TECNOLOGIAS UTILIZADAS:

○ Navegação via fragment

○ Implementação de arquitetura mvvm

o Feature offline(banco de dados);

○ Dados dinâmicos(consumo de API)

○ Aplicação de conceito SOLID

○ Aplicação de conceito clean code

## DEPENDÊNCIAS DO PROJETO:

dependencies {

    implementation 'androidx.core:core-ktx:1.8.0'
    implementation 'androidx.appcompat:appcompat:1.4.2'
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation 'androidx.cardview:cardview:1.0.0'

    // gson
    implementation 'com.google.code.gson:gson:2.9.0'
    implementation "com.squareup.retrofit2:converter-gson:2.6.0"

    //network connection
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-moshi:2.9.0"
    implementation "com.squareup.okhttp3:logging-interceptor:4.2.1"

    //lifecycle
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'
    implementation 'androidx.annotation:annotation:1.4.0'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.1'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.1'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.1'

    //navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.1")

    //room
    implementation("androidx.room:room-runtime:2.4.2")
    kapt("androidx.room:room-compiler:2.4.2")

    //picasso
    implementation 'com.squareup.picasso:picasso:2.71828'

    //moshi
    def moshi_version = "1.11.0"
    implementation"com.squareup.moshi:moshi-kotlin:$moshi_version"
}


## DESENVOLVEDOR DO PROJETO:

|[<img src="https://avatars.githubusercontent.com/Adriano-konig" width=115><br><sub>Adriano Konig</sub>](https://github.com/28drico) |
| :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
