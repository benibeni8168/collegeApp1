package com.example.myapplication.Screens.Dashboard.mainScreen

@Composable
fun showaccessError(showaccessEror: MutableState<Boolean>) {

    Dialog(onDismissRequest = { /*TODO*/ }) {


    Surface(Modifier.fillMaxWidth(),
        color = Color.White) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            textout(
                title = "Error",
                modifier = Modifier,
                fontStyle = MaterialTheme.typography.titleLarge,
                color = Color.Red
            )

            Text(
                text = "Authorized Access Only",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
                fontFamily = ralewayfamilt
            )


            button(text = "Ok") {
                showaccessEror.value = false


            }
            Spacer(modifier = Modifier.height(20.dp))


        }


    }
    }



}