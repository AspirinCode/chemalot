/*
   Copyright 2006-2014 Man-Ling Lee & Alberto Gobbi

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

Contact: aestelSW@gmail.com
*/
package com.aestel.chemistry.openEye.nn;

import openeye.oechem.OEMolBase;
import openeye.oechem.oechem;
import openeye.oechem.oemolothread;

/**
 * add tags with all similarities to the sdf record.
 * Tags added: NNSim, NNIdx, NNCount_<countSimilarityTheshold>
 *
 * @author albertgo
 *
 */
public class NNMatrixFinderConsumer implements NNMatrixFinderConsumerInterface
{  private final oemolothread ofs;
   private final String countSimilarityTheshold;

   public NNMatrixFinderConsumer(String outFile, String countSimilarityTheshold)
   {  this.ofs = new oemolothread(outFile);
      this.countSimilarityTheshold = countSimilarityTheshold;
   }


   @Override
   public void consumeResult(OEMolBase mol, double maxSim, int nnIdx, int countSimilar)
   {  oechem.OESetSDData(mol, "NNSim", String.format("%.4f",maxSim));
      oechem.OESetSDData(mol, "NNIdx", Integer.toString(nnIdx));

      if( countSimilarityTheshold != null )
         oechem.OESetSDData(mol, "NNCount_"+countSimilarityTheshold, Integer.toString(countSimilar));


      oechem.OEWriteMolecule(ofs, mol);
   }

   @Override
   public void close()
   {  ofs.close();
      ofs.delete();
   }
}
