# jetpack-compose-paging

## [View Model](https://developer.android.com/topic/libraries/architecture/viewmodel?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lY-JDt6C1uh2Nr4r-1Q65tvKIkZJv8EA7kVkIyE0_UokpQYpw89IchoC4uoQAvD_BwE&gclsrc=aw.ds)
A classe ViewModel foi projetada para armazenar e gerenciar dados relacionados à IU considerando o ciclo de vida. A classe ViewModel permite que os dados sobrevivam às mudanças de configuração, como a rotação da tela.

## [Corrotinas do Kotlin no Android](https://developer.android.com/kotlin/coroutines?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lQzJ-3Eiv2px-E23Iq12uadkReNe2n_N2OGrnHSjp8wU1sJT4oDzpRoCb_sQAvD_BwE&gclsrc=aw.ds)
Uma corrotina é um padrão de projeto de simultaneidade que você pode usar no Android para simplificar o código que é executado de forma assíncrona. Corrotinas foram adicionadas ao Kotlin na versão 1.3 e são baseadas em conceitos estabelecidos de outras linguagens (link em inglês).
No Android, as corrotinas ajudam a gerenciar tarefas de longa duração que podem bloquear a linha de execução principal e fazer com que seu app pare de responder. Mais de 50% dos desenvolvedores profissionais que usam corrotinas notaram um aumento na produtividade. Este tópico descreve como você pode usar corrotinas do Kotlin para resolver esses problemas, permitindo criar um código de app mais simples e conciso.

## [Retrofit](https://square.github.io/retrofit/)
O retrofit torna nossa HTTP API em interface java

## [Paging](https://developer.android.com/topic/libraries/architecture/paging?gclid=CjwKCAiAv_KMBhAzEiwAs-rX1ItQu1qirTI6C6Wnle8xWY8RSDqzjwag1AxaRg-W3mFMbpqr5FxdHxoCQacQAvD_BwE&gclsrc=aw.ds)
A biblioteca Paging ajuda a carregar e exibir pequenos blocos de dados por vez. O carregamento de dados parciais sob demanda reduz o uso da largura de banda da rede e dos recursos do sistema.

## [Kotlin FLow](https://developer.android.com/kotlin/flow?hl=pt-br)
Em corrotinas, um fluxo é um tipo que pode emitir vários valores sequencialmente, ao contrário das funções de suspensão, que retornam somente um valor. Por exemplo, você pode usar um fluxo para receber atualizações em tempo real de um banco de dados.

Os fluxos são criados com base nas corrotinas e podem fornecer vários valores. Conceitualmente, um fluxo é um stream de dados que pode ser computado de forma assíncrona. Os valores emitidos precisam ser do mesmo tipo. Por exemplo, um Flow<Int> é um fluxo que emite valores inteiros.

Um fluxo é muito semelhante a um Iterator que produz uma sequência de valores, mas usa funções de suspensão para produzir e consumir valores de maneira assíncrona. Isso significa, por exemplo, que o fluxo pode fazer uma solicitação de rede com segurança para produzir o próximo valor sem bloquear a linha de execução principal.

Há três entidades envolvidas em streams de dados:

Um produtor produz dados que são adicionados ao stream. Graças às corrotinas, os fluxos também podem produzir dados de maneira assíncrona.
Intermediários (opcionais) podem modificar cada valor emitido para o stream ou o próprio stream.
Um consumidor consome os valores do stream.