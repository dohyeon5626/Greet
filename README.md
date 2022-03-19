# Greet란?

저의 GITHUB를 방문하는 분들을 위해 README에서 날짜별 문구를 보여주기 위한 SVG API를 제공하는 프로젝트입니다.

> https://github.com/dohyeon5626
> 제 GITHUB를 재미나게 보여주고 싶어서 재미삼아 만들어보게 되엇습니다. 😀
> 한글날이나 새해, 크리스마스 등 특별한 날에 놀러오시면 재미난 문구를 구경할 수 있습니다.

#### DATE SVG

``` markdown
![DATE](https://dohyeon5626-greet.herokuapp.com/date)
```

> 해당 날짜의 SVG를 반환시켜줍니다.

#### SENTENCE SVG

``` markdown
![SENTENCE](https://dohyeon5626-greet.herokuapp.com/sentence)
```

> 날짜마다 해당하는 문구의 SVG를 랜덤으로 반환시켜줍니다.
> Greet Repository의 svg브랜치에 폴더별로 날짜별 SVG들이 정리되어있습니다.
> svg브랜치에 svg정보를 저장하는 이벤트가 생기면 서버가 webhook으로 이벤트를 받고 girhub api를 이용하여 새로 svg정보를 저장합니다.