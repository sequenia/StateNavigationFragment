[![](https://jitpack.io/v/sequenia/StateNavigationFragment.svg)](https://jitpack.io/#sequenia/StateNavigationFragment)

# StateNavigationFragment

Навигация на основе [Google Navigation](https://developer.android.com/guide/navigation) с возможностью сохранять состояние фрагментов.

## Подключение

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.sequenia.StateNavigationFragment:state_navigation_fragment:Y.Y.Y'
}
```

> Не забудьте подключить 

```
implementation "androidx.lifecycle:lifecycle-extensions:X.X.X"
annotationProcessor "androidx.lifecycle:lifecycle-compiler:X.X.X"

implementation "androidx.navigation:navigation-fragment:Z.Z.Z"
implementation "androidx.navigation:navigation-ui:Z.Z.Z"
```

## Использование

### Создание графа

В директории `res` создается пакет `navigation`, который хранит все графы приложения.

В  `main_graph.xml` перечисляются фрагменты для пунктов меню. Графу задается стартовый фрагмент
```
app:startDestination="@id/mainFragment"
```
При описание фрагментов необходимо использовать `<state_fragment>` взамен `<fragment>` 
```
<state_fragment
      android:id="@+id/mainFragment"
      android:name="com.example.statenavigationfragment.fragments.graphs.MainFragment"
      android:label="fragment_main"
      tools:layout="@layout/main_fragment" />
```

### Задание NavHostFragment

В `main_activity.xml` задается `StateNavHostFragment` фрагменту, который служит контейнером навигации. 
```
<fragment
      android:id="@+id/main_controller"
      android:name="com.sequenia.state_navigation_fragment.StateNavHostFragment"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      app:defaultNavHost="true"
      app:navGraph="@navigation/main_graph" />
```

### Навигация для пунктов меню

Каждый пункт меню имеет свою навигацию. Поэтому разметка фрагмента для пункта меню схожа с `main_activity.xml`. 
```
<fragment
      android:id="@+id/main_controller"
      android:name="com.sequenia.state_navigation_fragment.NavHostFragment"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      app:defaultNavHost="true"
      app:navGraph="@navigation/main_graph" />
```
> Обратите внимание! Используется NavHostFragment. При описание фрагментов используется `<fragment>`.

### Взаимодействие с навигацией

Последовательность переходов между пунктами меню не сохраняется, поэтому перед открытием нового пункта меню, необходимо удалить из стека текущий экран и открыть новый. 
> Обратите внимание! Навигация внутри фрагментов сохраняется.
```
bottomNavigationView.setOnNavigationItemSelectedListener(
      new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              mainController.popBackStack();
              mainController.navigate(menuItem.getItemId());
              return true;
          }
      });
```

### Передача результата между экранами

Для возвращения на экран можно использовать `action`. Имя `action` формируется из имени экрана, с которого осуществляется переход, и имени экрана, на который осуществляется переходят. Атрибутом `acapp:popUpTo` задается `id` экрана, до какого необходимо вернуться.
```
<action
    android:id="@+id/action_emailSendFragment_to_emailFragment"
    app:popUpTo="@+id/emailFragment" />
 ```

При возвращение на экран в Google Navigation не предусмотрена передача параметров. Поэтому Google предлагает использовать `ViewModel`. Библиотека предоставляет интерфейс для передачи и приема результата как между Fragment, так и между Activity. Для этого необходимо реализовать интерфейс `ScreenResultHandler` и добавить следующий код:
```
@Override
public void onResume() {
    super.onResume();
    checkReceivedScreenResult();
}
 ```

Метод `checkReceivedScreenResult()` проверяет наличие результата во `ViewModel`. Если во `ViewModel` есть результат, то вызывается метод. 
```
boolean onScreenResultReceive(@NonNull Bundle bundle)
 ```

По умолчанию метод `onScreenResultReceive` возращает `false`. Метод `onScreenResultReceive` должен возвращать `true`, если результат получен и обработан. 

Результат задается вызовом метода `setScreenResult` принимает `Bundle`
```
Bundle bundle = new Bundle();
bundle.putBoolean("RESULT_SEND", true);
setScreenResult(bundle);
```
