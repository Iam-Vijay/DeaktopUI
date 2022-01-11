import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BasePage(){


    val index = remember { mutableStateOf(0) }

    Card(modifier = Modifier.fillMaxSize().padding(5.dp),shape = RoundedCornerShape(10.dp),backgroundColor = androidx.compose.ui.graphics.Color.White){
      Column(modifier = Modifier.fillMaxSize()) {

          Row(modifier = Modifier.fillMaxWidth().height(80.dp).background(LightBlue50),verticalAlignment = Alignment.CenterVertically) {

              Image(
                  painter = painterResource("mainlogo.png"),
                  "",
                  modifier = Modifier.height(80.dp).width(200.dp).padding(start = 10.dp)
              )

              Spacer(Modifier.size(450.dp))

              Card (backgroundColor = Color.White,shape = RoundedCornerShape(10.dp),modifier = Modifier.size(50.dp).padding(2.dp)){
                  BadgedBox(badge = {
                      Card(backgroundColor = myred,shape = RoundedCornerShape(5.dp)) {
                          Text("20",modifier = Modifier.padding(2.dp), color = Color.White, fontSize = 10.sp)
                      }
                  }, modifier = Modifier.size(30.dp).padding(10.dp), content = {

                      Icon(
                          Icons.Outlined.FavoriteBorder,
                          contentDescription = "Favorite"
                      )
                  })
              }

              Card (backgroundColor = Color.White,shape = RoundedCornerShape(10.dp),modifier = Modifier.size(50.dp).padding(2.dp)){
                  BadgedBox(badge = {
                      Card(backgroundColor = myred,shape = RoundedCornerShape(5.dp)) {
                          Text("30",modifier = Modifier.padding(2.dp), color = Color.White, fontSize = 10.sp)
                      }
                  }, modifier = Modifier.size(30.dp).padding(10.dp), content = {

                      Icon(
                          Icons.Outlined.Person,
                          contentDescription = "person"
                      )
                  })
              }
          }



          Row(modifier = Modifier.fillMaxSize()) {
              Box(modifier = Modifier.background(mywhite).width(150.dp).fillMaxHeight()) {
                  var list = mutableListOf<Menu>()

                  list.add(Menu("Home",Icons.Outlined.Home))
                  list.add(Menu("Wallet",Icons.Outlined.ShoppingCart))
                  list.add(Menu("Transfers",Icons.Outlined.AddCircle))
                  list.add(Menu("Deposit",Icons.Outlined.Refresh))
                  list.add(Menu("Pay Services",Icons.Outlined.PlayArrow))
                  list.add(Menu("Phone Recharge",Icons.Outlined.AccountBox))

                  NavigationMenu(list) { pos ->
                      index.value = pos
                      print(pos)
                  }

              }
                var colorarray = arrayListOf<Color>()
              colorarray.add(Red100)
              colorarray.apply {
                  add(LightBlue700)
                  add(Orange700)
                  add(LightGreen900)
                  add(Color.LightGray)
                  add(CyanA200)
              }
              Box(modifier = Modifier.fillMaxSize().background(color = colorarray[index.value])){
                  Text(index.value.toString())
              }


          }

      }
  }
}