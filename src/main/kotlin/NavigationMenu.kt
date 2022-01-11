import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationMenu(list: List<Menu>, onSelected: (index: Int) -> Unit) {

    val selection = remember {
        mutableStateListOf(*list.map { false }.toTypedArray())
    }
    val oldstate = remember { mutableStateOf(0) }
    val selected = remember { mutableStateOf(false) }


    selection[oldstate.value] = true

    LazyColumn {

        itemsIndexed (items = list){index,data ->

              if (!selection[index]) {

                  Row(
                      modifier = Modifier.fillMaxSize().padding(5.dp)
                          .selectable(selected = selection[index] == selected.value) {
                              onSelected(index)
                               selection[oldstate.value] = false
                              selection[index] = true
                              oldstate.value = index
                          }, verticalAlignment = Alignment.CenterVertically
                  ) {

                      Icon(data.icon, data.tittle, modifier = Modifier.padding(5.dp).size(18.dp), tint = Black)
                      Text(
                          data.tittle!!,
                          fontSize = 12.sp,
                          fontFamily = FontFamily.Cursive,
                          color = Black,
                          modifier = Modifier.padding(5.dp).width(60.dp)
                      )
                      Spacer(modifier = Modifier.size(20.dp))
                      Icon(
                          Icons.Default.KeyboardArrowRight,
                          data.tittle,
                          modifier = Modifier.padding(5.dp).size(18.dp),
                          tint = Black
                      )
                  }
              }
           else {
                Card(
                    backgroundColor = Color.Black,
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier.padding(5.dp).fillMaxWidth().height(40.dp)
                ) {
                    Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                        Icon(data.icon, data.tittle, modifier = Modifier.padding(5.dp).size(18.dp), tint = White)
                        Text(
                            data.tittle!!,
                            fontSize = 12.sp,
                            fontFamily = FontFamily.Cursive,
                            color = White,
                            modifier = Modifier.padding(5.dp).width(60.dp)
                        )
                        Spacer(modifier = Modifier.size(20.dp))
                        Icon(
                            Icons.Default.KeyboardArrowRight,
                            data.tittle,
                            modifier = Modifier.padding(5.dp).size(18.dp),
                            tint = White
                        )
                    }

                }


            }
        }

    }
}

data class Menu(var tittle:String? = null,var icon:ImageVector)


